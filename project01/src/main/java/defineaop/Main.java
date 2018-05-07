package defineaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangxin on 2018/4/26.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans1.xml");
        Hello hello=(Hello) context.getBean("hello");
        hello.add();
        hello.delete();
    }
}
