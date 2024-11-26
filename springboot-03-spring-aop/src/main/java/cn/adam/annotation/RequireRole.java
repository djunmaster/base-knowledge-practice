package cn.adam.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. 定义注解
/*
    @Target(ElementType.METHOD)
    @Target 是一个元注解，用于指定自定义注解可以放置的位置。元注解是指用来注解其他注解的注解。
    ElementType.METHOD 表示这个注解只能应用于方法上。如果尝试将此注解应用到其他元素（如类、字段等），编译器将会报错。
 */
@Target(ElementType.METHOD)
/*
    @Retention 也是一个元注解，它指定了注解信息将在何时可用。
        SOURCE：注解仅存在于源代码级别，编译后会被丢弃。
        CLASS：默认值，注解会保留在class文件中，但不会被加载到JVM中，因此运行时不可见。
        RUNTIME：注解不仅会保留在class文件中，还会被加载到JVM中，这意味着可以通过反射机制在运行时读取到这些注解的信息。
    RetentionPolicy.RUNTIME 表示@RequireRole注解的信息会在运行时保留，并且可以通过反射API访问到。
    这通常用于需要在运行时检查或处理注解信息的场景，比如权限控制、事务管理等。
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireRole {
    String value(); // 需要的角色
}
