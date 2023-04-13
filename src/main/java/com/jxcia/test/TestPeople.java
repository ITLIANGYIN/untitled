package com.jxcia.test;

import com.jxcia.Utils.MyBatisUtils;
import com.jxcia.dao.PeopleMapper;
import com.jxcia.pojo.People;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPeople {
    PeopleMapper pm=null;
    SqlSession session=null;
    @Before
    public void Init(){
        session=MyBatisUtils.getSession();
        pm=session.getMapper(PeopleMapper.class);
    }
    @After
    public  void destroy(){
        MyBatisUtils.closeSession(session);
    }
     @Test
    public void TestById(){
         People p=pm.selectPeopleById(1);
         System.out.println(p);
     }
}
