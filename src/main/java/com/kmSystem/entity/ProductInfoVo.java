package com.kmSystem.entity;

import lombok.*;

/**
 * PRODUCT_INFO
 */
@Data

public class ProductInfoVo {
    /**
     * 入库单号，入库单号
     */
    private String inventoryId;
    /**
     * 商品编号，商品编号
     */
    private String productId;
    /**
     * 商品名称，商品名称
     */
    private String productName;
    /**
     * 商品数量，商品总共的数量
     */
    private double productNumber;
    /**
     * 商品进价，商品进价
     */
    private double productPrice;
    /**
     * 商品类型，商品类型
     */
    private String productType;
    /**
     * 商品型号，商品型号
     */
    private String productVersion;
    /**
     * 更新时间，更新时间
     */
    private String updatedDate;

}
