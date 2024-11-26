package cn.adam.service;

import cn.adam.annotation.DynamicTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

@Service
public class OrderService {

    @DynamicTransactional(propagation = Propagation.REQUIRES_NEW)
    public void placeOrder(String orderId) {
        System.out.println("订单 " + orderId + " 下单成功！");
    }

    @DynamicTransactional(isolation = Isolation.SERIALIZABLE)
    public void checkOrder(String orderId) {
        System.out.println("订单 " + orderId + " 校验完成！");
    }
}
