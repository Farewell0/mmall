package com.wzz.mmall.service;

import com.github.pagehelper.PageInfo;
import com.wzz.mmall.common.ServerResponse;
import com.wzz.mmall.vo.OrderVo;

import java.util.Map;

/**
 * 订单和支付的业务逻辑
 */
public interface IOrderService {

    /**
     * 生成订单VO对象
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse createOrder(Integer userId, Integer shippingId);

    /**
     * 取消订单
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse<String> cancel(Integer userId, Long orderNo);

    /**
     * 获取购物车中订单选中的商品
     * @param userId
     * @return OrderProductVo
     */
    ServerResponse getOrderCartProduct(Integer userId);

    /**
     * 获取订单详情
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    /**
     * 订单分页列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);


    /**
     * 订单支付（支付宝支付）
     * @param userId 用户id
     * @param orderNo 订单号
     * @param path 服务器中支付二维码所在路径（WEB-INF/upload），会上传到ftp服务器
     * @return 支付结果集合Map<String, String>
     */
    ServerResponse pay(Integer userId, Long orderNo, String path);

    /**
     * 处理支付宝回调的业务逻辑
     * @param params
     * @return
     */
    ServerResponse aliCallback(Map<String, String> params);

    /**
     * 查询订单支付状态
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);


    // =============================backend=============================
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);
}
