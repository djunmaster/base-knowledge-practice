package cn.adam.config;

import cn.adam.properties.MyServiceProperties;
import cn.adam.service.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 生成 bean 后，执行的一系列操作，赋值参数值到MyService类当中
@Configuration
@ConditionalOnClass(MyService.class)
@EnableConfigurationProperties(MyServiceProperties.class)
public class MyAutoConfiguration {

    private final MyServiceProperties properties;

    public MyAutoConfiguration(MyServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public MyService myService() {
        MyService service = new MyService();
        service.setMessage(properties.getMessage());
        return service;
    }
}
