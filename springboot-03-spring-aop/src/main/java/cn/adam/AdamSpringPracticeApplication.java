package cn.adam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AdamSpringPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdamSpringPracticeApplication.class, args);
    }
}
