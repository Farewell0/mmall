package com.wzz.mmall.service;

import com.wzz.mmall.common.ServerResponse;
import com.wzz.mmall.pojo.Category;

import java.util.List;

/**
 * 商品分类管理的业务逻辑接口
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    /**
     * 递归查询节点id和所有子节点id
     * @param categoryId
     * @return
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
