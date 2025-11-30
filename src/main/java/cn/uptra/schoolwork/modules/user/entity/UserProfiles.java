package cn.uptra.schoolwork.modules.user.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_profiles")
public class UserProfiles {

    @TableId("uid")
    private Long uid;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String prefer;
}
