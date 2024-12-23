package com.databasewebapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class CRMLoggingAspect {

    //setup logging


    //setup pointer cut declarations
    @Pointcut("execution(* com.databasewebapp.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.databasewebapp.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.databasewebapp.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage()||forServicePackage()||forDAOPackage()")
    private void  forAppFlow(){}

    //Before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
         // display method we are calling
        String method=theJoinPoint.getSignature().toShortString();
        log.info("===>>> in @Before : calling method {}", method);
        //display the arguments  to the method

        //get the args
        Object[]args=theJoinPoint.getArgs();

        // return the args
        for(Object tempArg:args){
            log.info("===>>> Arguments: {}", args);
        }
    }
    // ADDING AFTER RETURNING ADVICE
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturningAspect(JoinPoint joinPoint,Object result){
        // display method we are calling
        String method=joinPoint.getSignature().toShortString();
        log.info("===>>> in @AfterReturning : calling method {}", method);
        // displaying the result
        log.info("Result is : {}", result);

    }

}
