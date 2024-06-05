package com.kmSystem.service;

import com.kmSystem.entity.ProductInfoVo;
import com.kmSystem.mapper.SelectProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class SelectProductServiceImpl implements SelectProductService {
    @Autowired
    private SelectProductMapper selectProductMapper;

    @Override
    public List<ProductInfoVo> selectProduct(String ProductId) {
        return selectProductMapper.selectProduct(ProductId);
    }
}
