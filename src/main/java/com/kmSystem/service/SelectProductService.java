package com.kmSystem.service;

import com.kmSystem.entity.ProductInfoVo;

import java.util.List;

public interface SelectProductService {

    List<ProductInfoVo> selectProduct(String ProductId);
}
