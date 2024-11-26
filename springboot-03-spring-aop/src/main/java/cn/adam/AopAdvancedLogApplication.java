package cn.adam;

import cn.adam.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopAdvancedLogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopAdvancedLogApplication.class, args);
        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.getSensitiveData("12345"));
        System.out.println(userService.calculateSum(10, 20));
    }
}
