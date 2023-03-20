package com.chinasofti.service;


import com.chinasofti.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 新增商品
     * @param product
     */
    public void insertProduct(Product product, String editorValue);

    /**
     * 查询商品列表
     * @param product
     * @return
     */
    List<Product> selectProductList(Product product);

    public void deleteProductByIds(String ids);
}
