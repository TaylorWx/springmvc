package spring_mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangxin on 2018/4/29.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
       /* UserDao userDao=(UserDao)context.getBean("userDao");
        System.out.println(userDao.selectUser().size());*/
    }
}
