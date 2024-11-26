package cn.adam.annotation;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1.定义注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicTransactional {
    Propagation propagation() default Propagation.REQUIRED; // 默认传播行为
    Isolation isolation() default Isolation.DEFAULT;       // 默认隔离级别
}
