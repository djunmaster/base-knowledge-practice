package cn.adam.aspect;

import cn.adam.annotation.DynamicTransactional;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

@Aspect
@Component
public class TransactionAspect {

    @Resource
    private PlatformTransactionManager transactionManager;

    @Around("@annotation(dynamicTransactional)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint, DynamicTransactional dynamicTransactional) throws Throwable {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition(dynamicTransactional.propagation().value());
        definition.setIsolationLevel(dynamicTransactional.isolation().value());

        TransactionStatus status = transactionManager.getTransaction(definition);

        Object result;
        try {
            result = joinPoint.proceed();
            transactionManager.commit(status);
        } catch (Throwable ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        return result;
    }
}
