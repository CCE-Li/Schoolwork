package cn.uptra.schoolwork.DTO;

import lombok.Data;

/**
 * 登录请求
 */

@Data
public class LoginRequest {
    private Long uid;
    private String password;
}
