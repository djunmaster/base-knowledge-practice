package cn.adam.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 作为yml文件中的配置项
@ConfigurationProperties(prefix = "my.service")
public class MyServiceProperties {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

