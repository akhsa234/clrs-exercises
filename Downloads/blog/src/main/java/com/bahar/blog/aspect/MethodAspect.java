package com.bahar.blog.aspect;


        import org.aspectj.lang.JoinPoint;
        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.*;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.stereotype.Component;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collection;
        import java.util.List;

@Aspect
@Component
public class MethodAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(MethodAspect.class);

    @Pointcut("execution(public * com.bahar.aspect.controller.*.*(..))")
    public void MethodLoggers() {
    }

    @Before("MethodLoggers()")
    public void beforeCall(JoinPoint joinPoint){
        //
    }

    @Around("MethodLoggers()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        LOGGER.info(proceedingJoinPoint.getSignature().getName(),
                proceedingJoinPoint.getTarget().getClass());
        Object result = proceedingJoinPoint.proceed();
        if (result instanceof Collection) {
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Object aName = list.get(i);
                list.add(aName);}
               // System.out.println(aName);}
            LOGGER.info(list.toString());
        } else {
            LOGGER.info(result.toString());
        }

        return result;
    }

    @AfterThrowing(value = "MethodLoggers()", throwing = "excp")
    public void expAsp(Exception excp) {
        LOGGER.error("server exp");
        excp.printStackTrace();
    }
}