package cn.adam.service;

import cn.adam.annotation.RequireRole;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @RequireRole("ADMIN")
    public void addProduct(String productName) {
        System.out.println("产品 " + productName + " 添加成功！");
    }

    @RequireRole("USER")
    public void viewProduct(String productName) {
        System.out.println("查看产品: " + productName);
    }
}
