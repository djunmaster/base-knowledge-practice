package cn.adam.entity.param;

public class ParamTypeA extends BaseParams {
    private String fieldA;

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    @Override
    public String toString() {
        return "ParamTypeA{" + "fieldA='" + fieldA + '\'' + '}';
    }
}
