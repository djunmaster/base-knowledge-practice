package cn.adam.enumeration;

import cn.adam.entity.param.ParamTypeA;
import cn.adam.entity.param.ParamTypeB;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public enum ParamStrategyEnum {
    TYPE_A(params -> {
        if (params instanceof ParamTypeA) {
            ((ParamTypeA) params).setFieldA("EnumDefaultValueA");
        }
    }),
    TYPE_B(params -> {
        if (params instanceof ParamTypeB) {
            ((ParamTypeB) params).setFieldB(888);
        }
    });

    private final Consumer<Object> handler;


    public void process(Object params) {
        handler.accept(params);
    }
}
