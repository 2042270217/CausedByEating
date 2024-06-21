package org.example.controller;

import org.apache.ibatis.annotations.Delete;
import org.example.pojo.Cart;
import org.example.pojo.Result;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cart")
@Validated
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/set")
    public Result<Cart> set(@RequestBody @Validated Cart cart) {
        if (cartService.set(cart)) {
            return Result.success();
        } else {
            return Result.error("食物与商家不匹配");
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Cart cart) {
        cartService.update(cart);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(int cartId) {
        cartService.delete(cartId);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Cart>> list(int businessId) {
        var list = cartService.list(businessId);
        return Result.success(list);
    }

}
