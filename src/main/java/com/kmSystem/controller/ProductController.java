package com.kmSystem.controller;

import com.kmSystem.common.ArgCommon;
import com.kmSystem.entity.NotificationVo;
import com.kmSystem.entity.ProductInfoVo;
import com.kmSystem.entity.ProductTypeContentVo;
import com.kmSystem.mapper.ProductMapper;
import com.kmSystem.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductMapper productMapper;
    ArgCommon argCommon = new ArgCommon();
    LogService log = new LogService();

    @PostMapping("/api/product/select")
    public List<ProductInfoVo> selectProductList(@RequestBody ProductInfoVo productInfo) {
        List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();
        //检索值设定
        ProductInfoVo productInfoVoCtrl = new ProductInfoVo();
        productInfoVoCtrl.setProductName(productInfo.getProductName() == null || productInfo.getProductName() == "" ? "%%" : "%" + productInfo.getProductName());
        productInfoVoCtrl.setProductType(productInfo.getProductType() == null || productInfo.getProductType() == "" ? "%%" : productInfo.getProductType());
        productInfoVoCtrl.setProductId(productInfo.getProductId() == null || productInfo.getProductId() == "" ? "%%" : productInfo.getProductId());

        List<ProductInfoVo> productInfoVoResultList = productMapper.selectProduct(productInfoVoCtrl);
        if (!productInfoVoResultList.isEmpty()) {
            return productInfoVoResultList;
        }
        return productInfoVoList;
    }

    @PostMapping("/api/product/delete")
    public NotificationVo deleteProduct(@RequestBody ProductInfoVo productInfo) {

        NotificationVo notificationVo = new NotificationVo();

        //检索数据是否存在
        ProductInfoVo productInfoVoCtrl = new ProductInfoVo();
        productInfoVoCtrl.setProductName("%%");
        productInfoVoCtrl.setProductType("%%");
        productInfoVoCtrl.setProductId(productInfo.getProductId());
        List<ProductInfoVo> productInfoVoResultList = productMapper.selectProduct(productInfoVoCtrl);

        if (!argCommon.NULL.equals(productInfoVoResultList.get(0).getProductName())) {
            Integer resultNum = productMapper.deleteProduct(productInfo);
            if (resultNum != 0) {
                //弹窗信息设定
                notificationVo.setReslutMsg("OK", "success", "删除成功", productInfoVoResultList.get(0).getProductName() + "删除完成");
                log.warn("1");
                return notificationVo;
            } else {
                notificationVo.setReslutMsg("ERROR", "error", "删除失败", null);
                return notificationVo;
            }
        } else {
            //弹窗信息设定
            notificationVo.setReslutMsg("ERROR", "error", "删除失败", productInfoVoResultList.get(0).getProductName()+"数据不存在");
            return notificationVo;
        }
    }

    @PostMapping("/api/product/selectType")
    public List<ProductTypeContentVo> selectType() throws Exception {
        List<ProductTypeContentVo> productTypeInfo = productMapper.selectType();
        return productTypeInfo;
    }

    @PostMapping("/api/product/update")
    public NotificationVo updateProduct(@RequestBody ProductInfoVo productInfo) {

        NotificationVo notificationVo = new NotificationVo();

        //检索数据是否存在
        ProductInfoVo productInfoVoCtrl = new ProductInfoVo();
        productInfoVoCtrl.setProductName("%%");
        productInfoVoCtrl.setProductType("%%");
        productInfoVoCtrl.setProductId(productInfo.getProductId());
        List<ProductInfoVo> productInfoVoResultList = productMapper.selectProduct(productInfoVoCtrl);

        if (!argCommon.NULL.equals(productInfoVoResultList.get(0).getProductName())) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
            productInfo.setUpdatedDate(formatter.format(date));
            System.out.println(formatter.format(date));
            Integer resultNum = productMapper.updateProduct(productInfo);
            System.out.println(formatter.format(resultNum));
            if (resultNum != 0) {
                //弹窗信息设定
                notificationVo.setReslutMsg("OK", "success", "更新成功", productInfoVoResultList.get(0).getProductName() + "更新完成");
                log.info("1");
                return notificationVo;
            } else {
                //弹窗信息设定
                notificationVo.setReslutMsg("ERROR", "error", "更新失败", null);
                return notificationVo;
            }
        } else {
            //弹窗信息设定
            notificationVo.setReslutMsg("ERROR", "error", "更新失败", productInfoVoResultList.get(0).getProductName() + "数据不存在");
            return notificationVo;
        }
    }

}