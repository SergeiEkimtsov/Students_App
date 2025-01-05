package com.ekimtsovss.students_app.aop;

import com.ekimtsovss.students_app.service.ServiceStudent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.ekimtsovss.students_app.service .*.*(..))")
    public  Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = Logger.getLogger(LoggingAspect.class.getName());
        var methodSignature = joinPoint.getSignature();
        long t = System.currentTimeMillis();
        logger.info("Method "+ methodSignature.getName() + " will execute");
        Object result = joinPoint.proceed();
        logger.info("Execution time=" + (System.currentTimeMillis() - t) + "ms");
        logger.info("Method "+ methodSignature.getName() + " executed");
        System.out.println(result);
        return result;

    }

}
