package com.jxcia.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxcia.Utils.MyBatisUtils;
import com.jxcia.dao.EmployeeMapper;
import com.jxcia.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEmployee {
    EmployeeMapper em=null;
    SqlSession session=null;
    @Before
    public void Init(){
        session= MyBatisUtils.getSession();
        em=session.getMapper(EmployeeMapper.class);
    }
    @After
    public  void destroy(){
        MyBatisUtils.closeSession(session);
    }
    @Test
    public void testAdd(){
        Employee e=new Employee("xiaoli", "zhangsan@163.com", 1, 18);
        int count = em.insert(e);
        System.out.println(count>0?"成功":"失败");
    }
    //运行不通过找不到配置文件是因为方式是父项目pom，无法编译resource下面的文件,jar才可以运行
    @Test
    public  void findById(){

        System.out.println(em.selectById(1));
    }
    @Test
    public  void countTest(){
            int count=  em.countAll();
            System.out.println("总行数："+count);


    }
    @Test
    public  void add(){
        Employee employee=new Employee("赵四","@",0,20);
        int count= em.insert(employee);
        System.out.println(count>0?"新增成功":"新增失败");
    }
    @Test
    public  void add2(){
        for(int i=1;i<=50;i++) {
            Employee employee = new Employee("赵四" + i, "@", 0, 20);
            int count = em.insert(employee);
            System.out.println(count > 0 ? "新增成功" : "新增失败");
        }
    }
    @Test
    public  void  update(){
        Employee employee=new Employee();
        employee.setId(1);
        employee.setLastName("赵四");
        int count= em.updateById(employee);
        System.out.println(count>0?"更新成功":"更新失败");
    }
    @Test
    public  void  delete(){
        int count=em.deleteById(6);
        System.out.println(count>0?"删除成功":"删除失败");
    }
    public  void  delete2(){
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        int count=em.deleteBatchIds(ids);
        System.out.println(count>0?"删除成功":"删除失败");
    }
    public  void  delete3(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("gender",1);//条件
        map.put("last","赵四9");
        int count=em.deleteByMap(map);
        System.out.println(count>0?"删除成功":"删除失败");
    }
    @Test
    public  void findByIdAndName(){
       Employee u= em.selectByIdAndName(3,"赵四");//根据id，名字查找数据
        System.out.println(u);
    }
    @Test
    public  void testFindList(){
        //条件构造器
        QueryWrapper qw=new QueryWrapper();
        qw.eq("gender",1);//等于
        qw.or();
        qw.gt("age",20);//大于
//        qw.lt("age",20);//小于
        List<Employee> list=em.selectList(qw);
        for (Employee e:list){
            System.out.println(e);
        }
    }
    @Test
    public void FindByBetween(){
        QueryWrapper<Employee> qw=new QueryWrapper<Employee>().between("age",21,50)
                .lt("id",100).orderBy(true,true,"age");
        List<Employee> list=em.selectList(qw);
        for (Employee e:list){
            System.out.println(e);
        }
    }
    @Test
    public void TestLike(){
        QueryWrapper<Employee> qw=new QueryWrapper<Employee>().gt("age",15)
                .likeLeft("last_name","0");
        List<Employee> list=em.selectList(qw);
        for (Employee e:list){
            System.out.println(e);
        }
    }
    @Test
    public void TestLast(){
        String key="0";
        QueryWrapper<Employee> qw=new QueryWrapper<Employee>().gt("age",15)
                .last("and last_name like '%"+key+"%'");
        List<Employee> list=em.selectList(qw);
        for (Employee e:list){
            System.out.println(e);
        }
    }
    @Test
    //select max(age),min(age) from employee
    public  void testMaxAndMin(){
        //创建条件构造器
        QueryWrapper query=new QueryWrapper();
        //设置查询结果
//        query.select("max(age),min(age)");
        query.select("max(age) maxAge,min(age) minAge");//取别名
        //调用Plus提供的selectMaps方法
        List<Map<String,Object>> list=em.selectMaps(query);
        System.out.println(list);
        //拿去返回集合中的Map
        Map<String,Object> map= list.get(0);
        //通过key值取出值
        Object maxAge= map.get("maxAge");
        Object minAge= map.get("minAge");
        System.out.println("max(age)="+maxAge);
        System.out.println("min(age)="+minAge);
    }
    @Test
    //select count(1), gender from employee group by gender having count(1)>5 ORDER BY count(1) desc
    public void testFindSex(){
        QueryWrapper query=new QueryWrapper();
        query.select("count(1)","gender");
        query.groupBy("gender");
//        query.having("count(1)>5");
        query.having("count(1)");
        query.orderByDesc("count(1)");
        List<Map<String,Object>> list=em.selectMaps(query);
        System.out.println(list);
        for(Map<String,Object> map:list){
            System.out.println("gender为："+map.get("gender")+"的人数为"+map.get("count(1)"));
        }
    }
    @Test
    //分页
    public void testPage(){
        int pageIndex=1;//从哪里开始
        int pageSize=5;//页面大小
        QueryWrapper query=new QueryWrapper();
        query.like("last_name","0");
        Page page= em.selectPage(new Page<Employee>(pageIndex,pageSize),query);

        System.out.println(page);
        Long current= page.getCurrent();
        System.out.println("current="+current);
        //总数
        Long total= page.getTotal();
        System.out.println("total="+total);
        //分页总数
        Long pages= page.getPages();
        System.out.println("pages="+pages);
        //返回所有记录
        List<Employee> list= page.getRecords();
        for(Employee e:list){
            System.out.println(e);
        }
    }
}
