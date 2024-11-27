package cn.adam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Springboot01UseMyStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01UseMyStarterApplication.class, args);
    }
}
