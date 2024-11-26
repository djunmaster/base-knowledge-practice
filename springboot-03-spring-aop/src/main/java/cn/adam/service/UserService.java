package cn.adam.service;

import cn.adam.annotation.LogExecution;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @LogExecution(encryptReturnValue = true)
    public String getSensitiveData(String userId) {
        return "SensitiveInfoForUser_" + userId; // 模拟返回敏感信息
    }

    @LogExecution
    public int calculateSum(int a, int b) {
        return a + b;
    }
}
