package cn.adam.service.impl;

import cn.adam.api.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookDaoImpl implements BookDao, InitializingBean, DisposableBean {
    public void save() {
        System.out.println("book dao save ...");
    }

    @Override
    public void destroy() throws Exception {
        // 销毁前调用
        System.out.println("destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化后调用
        System.out.println("init...");
    }
}