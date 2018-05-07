package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_project01.User;

/**
 * Created by wangxin on 2018/4/25.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("springaopapi/beans.xml");
        /*Hello hello=(Hello) context.getBean("hello");
        hello.show();*/
        User user=(User)context.getBean("u1");
        System.out.println(user);
    }
}
