package com.kmSystem.controller;

import com.kmSystem.entity.ProductInfoVo;
import com.kmSystem.service.ProductService;
import com.kmSystem.service.ProductServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @PostMapping("/api/product/select")
    public List<ProductInfoVo> SelectproductList(@RequestBody ProductInfoVo productInfo) throws Exception {
        List <ProductInfoVo> productInfoVoList =new ArrayList<ProductInfoVo>();
        List<ProductInfoVo> productInfoVoResultList =  selectProduct(productInfo);
        if (!productInfoVoResultList.isEmpty()) {
            return productInfoVoResultList;
        }
    return productInfoVoList;
    }

@Resource
private ProductService productService = new ProductServiceImpl();

@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
public List<ProductInfoVo> selectProduct(ProductInfoVo productInfo) {
    StringBuffer productSQL = null;
    List<ProductInfoVo> list = null;
    if(productInfo != null) {
        if (productInfo.getProduct_id() != null) {
            productSQL.append("product_id =").append(productInfo.getProduct_id());
        }// 根据商品编码查询
        if (productInfo.getProduct_type() != null) {
            productSQL.append("product_type =").append(productInfo.getProduct_type());
        }// 根据商品类型查找
        if (productInfo.getProduct_name() != null) {
            productSQL.append("product_name LIKE %").append(productInfo.getProduct_name() + "%");
        }// 根据商品名称查找}
        list = productService.selectProduct(productSQL);
    return list;
    } else {
        return list = productService.selectProduct(null);
    }
}
}