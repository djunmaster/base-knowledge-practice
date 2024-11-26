package cn.adam;

import cn.adam.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopAdvancedRoleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopAdvancedRoleApplication.class, args);
        ProductService productService = context.getBean(ProductService.class);

        productService.viewProduct("Laptop"); // 普通用户可以查看
        productService.addProduct("Phone");   // 普通用户尝试添加
    }
}
