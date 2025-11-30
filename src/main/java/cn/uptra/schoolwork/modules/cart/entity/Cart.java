package cn.uptra.schoolwork.modules.cart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("carts")
public class Cart {
    @TableId("id")
    private int id;

    private Long uid;
    private Long bid;
    private int number;

}
