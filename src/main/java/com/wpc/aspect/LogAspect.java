package com.wpc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.wpc.aspect.Log)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before ......" + joinPoint.getTarget().toString());
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String moduleName = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    moduleName = method.getAnnotation(Log.class).moduleName();
                }
            }
            System.out.println("after ......" + moduleName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("after-throwing ......" + joinPoint.getTarget().toString());
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("after-returning ......"  + joinPoint.getSignature().getName() + "：" + result);
    }

    @Around(value = "pointcut()", argNames = "pjp")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("around ......1");
            Object proceed =  pjp.proceed();
            System.out.println("around ......2");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
