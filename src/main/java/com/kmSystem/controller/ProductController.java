package com.kmSystem.controller;

import com.kmSystem.entity.ProductInfoVo;
import com.kmSystem.service.SelectProductService;
import com.kmSystem.service.SelectProductServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @PostMapping("/api/product/select")
    public List<ProductInfoVo> SelectproductList(@RequestParam("productId_serch") String productIdSerch) throws Exception {
        List <ProductInfoVo> productInfoVoList =new ArrayList<ProductInfoVo>();
        List<ProductInfoVo> productInfoVoResultList =  selectProduct(productIdSerch);
        if (!productInfoVoResultList.isEmpty()) {
            System.out.println(productInfoVoResultList.size());
            for (ProductInfoVo productInfoVo : productInfoVoResultList) {
            System.out.println(productInfoVo.getProduct_name());}
            return productInfoVoResultList;
        }
    return productInfoVoList;
    }

@Resource
private SelectProductService productService = new SelectProductServiceImpl();

@RequestMapping(value = "/selectProduct", method = RequestMethod.GET)
public List<ProductInfoVo> selectProduct(String productIdSerch) {
    List<ProductInfoVo> list = productService.selectProduct(productIdSerch);
    return list;
}
}