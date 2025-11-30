package cn.uptra.schoolwork.modules.cart.controller;

import cn.uptra.schoolwork.common.result.R;
import cn.uptra.schoolwork.modules.cart.entity.Cart;
import cn.uptra.schoolwork.modules.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     *  添加商品到购物车
     *  1. 请求体包含商品信息（商品ID、数量等）
     *  2. 用户ID作为请求参数传递
     *  3. 当已经添加过相同商品时，数量 + number
     *  4. 用户未登录时，返回错误提示
     *  @param cart 购物车商品信息
     *  @param uid 用户ID
     *  @return 操作结果
     */
    @PostMapping("/add")
    public R<Cart> addToCart(@RequestBody Cart cart,
                             @RequestParam("uid") Long uid){
        if (uid == null) {
            return R.error("用户未登录，无法添加到购物车");
        } else {
            Cart existingCartItem = cartService.getCartByIdAndUidAndBid(uid, cart.getBid());
            if (existingCartItem != null) {
                // 已存在相同商品，数量加 number
                existingCartItem.setNumber(existingCartItem.getNumber() + cart.getNumber());
                cartService.updateById(existingCartItem);
                return R.success();
            } else {
                // 不存在相同商品，添加新商品
                cart.setUid(uid);
                cartService.save(cart);
                return R.success();
            }
        }
    }

    /**
     * 获取用户的购物车列表
     * @param uid 用户ID
     * @return 购物车列表
     */
    @GetMapping("/list")
    public List<Cart> getCartItems(@RequestParam("uid") Long uid) {
        return cartService.list().stream()
                .filter(cart -> cart.getUid().equals(uid))
                .toList();
    }

    /**
     * 删除购物车项
     * 更具用户框选的bid列表删除对应的购物车项
     * @param uid 用户ID
     * @return 操作结果
     */
    @PostMapping("/delete")
    public R<Void> deleteCartItems(@RequestParam("uid") Long uid,
                                   @RequestBody List<Long> bidList) {
        List<Cart> userCartItems = cartService.list().stream()
                .filter(cart -> cart.getUid().equals(uid) && bidList.contains(cart.getBid()))
                .toList();
        if (!userCartItems.isEmpty()) {
            cartService.removeByIds(userCartItems.stream().map(Cart::getId).toList());
            return R.success();
        } else {
            return R.error("没有找到对应的购物车项");
        }
    }

    /**
     * 更新购物车中商品的数量，前端使用加减号实现
     * @param cart 购物车商品信息
     * @return 操作结果
     */
    @PostMapping("/update")
    public R<Void> updateCartItem(@RequestBody Cart cart) {
        Cart existingCartItem = cartService.getById(cart.getId());
        if (existingCartItem != null) {
            existingCartItem.setNumber(cart.getNumber());
            cartService.updateById(existingCartItem);
            return R.success();
        } else {
            return R.error("购物车项不存在");
        }
    }
}
