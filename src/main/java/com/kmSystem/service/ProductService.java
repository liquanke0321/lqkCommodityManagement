package com.kmSystem.service;

import com.kmSystem.entity.ProductInfoVo;

import java.util.List;

public interface ProductService {

    List<ProductInfoVo> selectProduct(StringBuffer ProductId);
}
