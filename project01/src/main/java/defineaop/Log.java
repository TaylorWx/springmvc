package defineaop;

import org.aspectj.apache.bcel.generic.ObjectType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by wangxin on 2018/4/26.
 */
@Aspect
public class Log {
    @Pointcut("execution(public * defineaop.HelloImpl.*(..))")
    public void match(){}
    @Before("match()")
    public void test(){
        System.out.println("000000000000000");
    }
    @Before("execution(* defineaop.HelloImpl.*(..))")
    public void before(){
        System.out.println("before---------------");
    }
    @Around("execution(* defineaop.HelloImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕之前");
        System.out.println(joinPoint.getSignature());
        Object result=joinPoint.proceed();
        System.out.println("环绕之后");
        return result;
    }
}
