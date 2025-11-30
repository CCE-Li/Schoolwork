package cn.uptra.schoolwork.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_favourites")
public class UserFavourites {
    @TableId("id")
    private int id;
    private Long uid;
    private Long bid;

}
