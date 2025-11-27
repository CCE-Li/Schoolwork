package cn.uptra.schoolwork.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id; // 主键：自增

    private Long uid;

    private String username;
    private String password;
    private Integer status;

    public void setUid(Long uid) {
        long mod = 10000000000L;
        if (uid == null) {
            throw new IllegalArgumentException("uid未生成，无法取模");
        }
        this.uid = uid % mod;
    }

}
