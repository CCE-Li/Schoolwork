package cn.uptra.schoolwork.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admins")
public class Admin {
    @TableId("id")
    private int id;

    private Long admin_id;
    private String username;
    private String password;
}
