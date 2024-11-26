package cn.adam.aspect;

import cn.adam.annotation.RequireRole;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 2. 编写切面
@Aspect
@Component
public class RoleCheckingAspect {

    // 当调用包含@annotation(requireRole的注解之前（Before），获取这个requireRole包含的value值
    @Before("@annotation(requireRole)")
    public void checkRole(JoinPoint joinPoint, RequireRole requireRole) {
        String requiredRole = requireRole.value();
        // 模拟从上下文中获取当前用户角色
        String currentUserRole = getCurrentUserRole();

        if (!requiredRole.equals(currentUserRole)) {
            throw new SecurityException("当前用户无权限执行该方法，需角色: " + requiredRole);
        }

        System.out.println("权限校验通过: 当前角色 " + currentUserRole);
    }

    // 模拟获取用户角色的方法
    private String getCurrentUserRole() {
        return "USER"; // 模拟返回当前用户角色
    }
}
