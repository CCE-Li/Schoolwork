package cn.uptra.schoolwork.modules.cart.service;

import cn.uptra.schoolwork.modules.cart.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CartService extends IService<Cart> {
    Cart getCartByIdAndUidAndBid(Long uid, Long bid);
}
