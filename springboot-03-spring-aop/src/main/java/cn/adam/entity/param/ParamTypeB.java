package cn.adam.entity.param;

public class ParamTypeB extends BaseParams {
    private int fieldB;

    public void setFieldB(int fieldB) {
        this.fieldB = fieldB;
    }

    @Override
    public String toString() {
        return "ParamTypeB{" + "fieldB=" + fieldB + '}';
    }
}