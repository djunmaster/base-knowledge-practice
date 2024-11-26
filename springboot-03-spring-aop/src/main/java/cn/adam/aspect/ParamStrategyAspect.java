package cn.adam.aspect;

import cn.adam.annotation.ApplyParamStrategy;
import cn.adam.enumeration.ParamStrategyEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParamStrategyAspect {

    @Around("@annotation(applyParamStrategy)")
    public Object processParams(ProceedingJoinPoint joinPoint, ApplyParamStrategy applyParamStrategy) throws Throwable {
        Object[] args = joinPoint.getArgs(); // 获取方法的参数
        ParamStrategyEnum[] strategies = applyParamStrategy.value(); // 获取注解中的策略

        for (Object arg : args) {
            for (ParamStrategyEnum strategy : strategies) {
                strategy.process(arg); // 应用策略
            }
        }

        // 执行目标方法
        return joinPoint.proceed(args);
    }
}
