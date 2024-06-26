package com.kmSystem.mapper;

import com.kmSystem.entity.ProductInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelectProductMapper {
    @Select({
            "select","*",
            "from product_info","where","product_id = '100008' "//#{productId} and password = #{password}
    })
    List<ProductInfoVo> selectProduct(@Param("productId") String productId);//, @Param("password") String password

}
