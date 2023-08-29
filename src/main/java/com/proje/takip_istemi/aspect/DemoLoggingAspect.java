package com.proje.takip_istemi.aspect;

import com.proje.takip_istemi.response.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger logger=Logger.getLogger(getClass().getName());


    @Pointcut("execution(* com.proje.takip_istemi.service.*.*(..))")
    private void serviceExecution() {};


    @Pointcut("execution(* com.proje.takip_istemi.service.*.save*(..))")
    private void serviceSave() {};

    @Pointcut("execution(* com.proje.takip_istemi.service.*.delete*(..))")
    private void serviceDeleteMethods() {};

    @Pointcut("execution(* com.proje.takip_istemi.service.*.update*(..))")
    private void serviceUpdateMethods() {};

    @Pointcut("serviceSave() || serviceDeleteMethods() || serviceUpdateMethods()")
    private void crudOperations(){}

    @AfterReturning( pointcut = "crudOperations()",returning = "result")
    public void afterServiceReturning(JoinPoint joinPoint, Object result){
    //    String method=joinPoint.getSignature().toShortString();
    //    logger.info("method name: "+method);

        if (result instanceof Response) {
            Response response = (Response) result;
            String message = response.getMessage();
            logger.info(message);
        }
        else {
            String mesaj= (String) result;
            logger.info(mesaj);
        }


    }


}
