package test;

import com.jxcia.bean.Meet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MeetTest {
    @Test
    public void meetTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("meet.xml");
        Meet meet=ac.getBean("b1",Meet.class);
        System.out.println(meet);
        Meet meet2=ac.getBean("b2",Meet.class);
        System.out.println(meet2);
        Meet meet3=ac.getBean("b3",Meet.class);
        System.out.println(meet3);
    }
}
