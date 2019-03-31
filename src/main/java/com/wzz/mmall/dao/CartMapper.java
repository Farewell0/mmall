package com.wzz.mmall.dao;

import com.wzz.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /**
     * 用来判断购物车中是否有此产品
     * @param userId
     * @param productId
     * @return
     */
    Cart selectCartByUserIdProductId(@Param("userId") Integer userId,
                                     @Param("productId") Integer productId);

    List<Cart> selectCartByUserId(Integer userId);

    /**
     * 只要是全选就返回0， 不是全选一定非0
     * @param userId
     * @return
     */
    int selectCartProductCheckedStatusByUserId(@Param("userId") Integer userId);

    /**
     * 根据用户id和产品id删除购物车中的产品
     * @param userId
     * @param productIdList
     * @return
     */
    int deleteByUserIdProductIds(@Param("userId") Integer userId,
                                 @Param("productIdList") List<String> productIdList);

    /**
     * 选中或不选中购物车中产品
     * @param userId
     * @param productId 产品id
     * @param checked 选中是1，未选中是0
     * @return
     */
    int checkedOrUncheckedProduct(@Param("userId") Integer userId,
                                  @Param("productId") Integer productId,
                                  @Param("checked") Integer checked);

    /**
     * 返回购物车中产品数量
     * @param userId
     * @return
     */
    int selectCartProductCount(Integer userId);

    List<Cart> selectCheckedCartByUserId(Integer userId);
}