package cn.uptra.schoolwork.modules.cart.mapper;

import cn.uptra.schoolwork.modules.cart.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    @Select("SELECT * FROM carts WHERE uid = #{uid} AND bid = #{bid} LIMIT 1")
    Cart getCartByIdAndUidAndBid(Long uid, Long bid);
}
