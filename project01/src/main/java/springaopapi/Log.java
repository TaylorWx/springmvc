package springaopapi;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by wangxin on 2018/4/26.
 */
public class Log implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("tongzhi  "+o.getClass().getName()+"  "+method.getName());
    }
}
