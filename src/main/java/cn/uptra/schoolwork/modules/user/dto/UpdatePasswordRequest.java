package cn.uptra.schoolwork.modules.user.dto;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String username;
    private String password;
}

