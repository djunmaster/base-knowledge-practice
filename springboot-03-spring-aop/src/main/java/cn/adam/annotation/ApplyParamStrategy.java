package cn.adam.annotation;

import cn.adam.enumeration.ParamStrategyEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplyParamStrategy {
    ParamStrategyEnum[] value(); // 绑定枚举策略
}
