package cn.uptra.schoolwork.DTO;

import lombok.Data;

/**
 * 登录响应
 */

@Data
public class LoginResponse {
    private String uid;
    private String password;
}
