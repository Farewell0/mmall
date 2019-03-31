package com.wzz.mmall.service;

import com.github.pagehelper.PageInfo;
import com.wzz.mmall.common.ServerResponse;
import com.wzz.mmall.pojo.Shipping;

import java.util.Map;

/**
 * 地址管理的业务逻辑
 */
public interface IShippingService {

    /**
     * 新建地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse<Map> add(Integer userId, Shipping shipping);

    ServerResponse<String> del(Integer userId, Integer shippingId);

    ServerResponse<String> update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
