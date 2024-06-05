package com.kmSystem.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * PRODUCT_INFO
 */
@Getter
@Setter
public class ProductInfoVo {
    /**
     * 入库单号，入库单号
     */
    private String inventory_id;
    /**
     * 商品编号，商品编号
     */
    private String product_id;
    /**
     * 商品名称，商品名称
     */
    private String product_name;
    /**
     * 商品数量，商品总共的数量
     */
    private double product_number;
    /**
     * 商品进价，商品进价
     */
    private double product_price;
    /**
     * 商品类型，商品类型
     */
    private String product_type;
    /**
     * 商品型号，商品型号
     */
    private String product_version;
}
