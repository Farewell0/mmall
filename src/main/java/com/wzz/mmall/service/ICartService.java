package com.wzz.mmall.service;

import com.wzz.mmall.common.ServerResponse;
import com.wzz.mmall.vo.CartVo;

public interface ICartService {

    /**
     * 将产品添加到指定用户的购物车
     * @param userId
     * @param count
     * @param productId
     * @return
     */
    ServerResponse<CartVo> add(Integer userId, Integer count, Integer productId);

    /**
     * 更新购物车
     * @param userId
     * @param count
     * @param productId
     * @return
     */
    ServerResponse<CartVo> update(Integer userId, Integer count, Integer productId);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> listProduct(Integer userId);

    ServerResponse<CartVo> selectAllOrUnSelect(Integer userId, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
