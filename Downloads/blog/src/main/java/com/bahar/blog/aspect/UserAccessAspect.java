package com.bahar.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Aspect
//@Configuration
@Component
public class UserAccessAspect {
    private static final Logger logger= LoggerFactory.getLogger(UserAccessAspect.class.getName());
// pointer+innercode --> aspect
    // join point --> execute specific methods
    // weavering+ weaver --> impliment and framework
    @Before("execution (* com.bahar.blog.*.*(..))") //pointer
    public void before(JoinPoint joinPoint){
        logger.info(" check for user access ...");
        logger.info(" allowed execution for {} ..."+ joinPoint);
    }
}

/*
 public class MethodLogger {
  @Around("execution(* *(..)) && @annotation(Loggable)")
  public Object around(ProceedingJoinPoint point) {
    long start = System.currentTimeMillis();
    Object result = point.proceed();
    Logger.info(
      "#%s(%s): %s in %[msec]s",
      MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
      point.getArgs(),
      result,
      System.currentTimeMillis() - start
    );
    return result;
  }
}


 */