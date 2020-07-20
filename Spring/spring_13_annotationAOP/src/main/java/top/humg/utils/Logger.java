package top.humg.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，提供公共代码
 */
@Component("logger")
@Aspect//配置为切面类
public class Logger {
    //打印日志，在切入点方法前执行（前置通知）
    public void beforePrintLog() {
        System.out.println("前置通知：printLog方法已经执行了");
    }

    //后置通知
    public void afterReturningPrintLog() {
        System.out.println("后置通知：printLog方法已经执行了");
    }

    //异常通知
    public void afterThrowingPrintLog() {
        System.out.println("异常通知：printLog方法已经执行了");
    }

    //最终通知
    public void afterPrintLog() {
        System.out.println("最终通知：printLog方法已经执行了");
    }

    //环绕通知
    public Object afterAroundPrintLog(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();//获取业务层方法所需参数
            System.out.println("前置通知：printLog方法已经执行了");
            Object result = pjp.proceed(args);//调用业务层方法（切入点方法）
            System.out.println("后置通知：printLog方法已经执行了");
            return result;
        } catch (Throwable throwable) {
            //捕捉到异常后，不再返回值，而是抛出异常
            throwable.printStackTrace();
            System.out.println("异常通知：printLog方法已经执行了");
            throw new RuntimeException("发生异常，无返回值");
        } finally {
            System.out.println("最终通知：printLog方法已经执行了");
        }
    }
}