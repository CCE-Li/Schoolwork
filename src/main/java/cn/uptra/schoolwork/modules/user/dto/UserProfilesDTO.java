package cn.uptra.schoolwork.modules.user.dto;

import lombok.Data;

@Data
public class UserProfilesDTO {
    private Long uid;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String prefer;
}
