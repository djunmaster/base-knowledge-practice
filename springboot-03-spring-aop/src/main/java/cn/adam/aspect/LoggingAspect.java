package cn.adam.aspect;

import cn.adam.annotation.LogExecution;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(logExecution)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint, LogExecution logExecution) throws Throwable {
        // 获取方法信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();

        // 记录调用前的时间
        long startTime = System.currentTimeMillis();
        System.out.println("调用方法: " + methodName);

        // 打印入参
        Object[] args = joinPoint.getArgs();
        System.out.println("方法参数: " + Arrays.toString(args));

        // 执行目标方法
        Object returnValue;
        try {
            returnValue = joinPoint.proceed();
        } catch (Throwable ex) {
            System.out.println("方法 " + methodName + " 执行时出错: " + ex.getMessage());
            throw ex;
        }

        // 记录执行时间
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("方法 " + methodName + " 执行时间: " + executionTime + " ms");

        // 对返回值加密（如果需要）
        if (logExecution.encryptReturnValue() && returnValue instanceof String) {
            returnValue = "Encrypted(" + returnValue + ")";
        }

        System.out.println("方法返回值: " + returnValue);
        return returnValue;
    }
}
