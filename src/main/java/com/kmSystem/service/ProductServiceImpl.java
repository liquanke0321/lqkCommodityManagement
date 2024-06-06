package com.kmSystem.service;

import com.kmSystem.entity.ProductInfoVo;
import com.kmSystem.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductInfoVo> selectProduct(StringBuffer ProductId) {
        return productMapper.selectProduct(ProductId);
    }
}
