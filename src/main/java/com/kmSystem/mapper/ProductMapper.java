package com.kmSystem.mapper;

import com.kmSystem.entity.ProductInfoVo;
import com.kmSystem.entity.ProductTypeContentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    //不用@Param传值的，在xml中直接写对象中的属性就可以
    List<ProductInfoVo> selectProduct(ProductInfoVo productInfoVoCtrl);
    Integer deleteProduct(ProductInfoVo productInfoVoCtrl);
    Integer updateProduct(ProductInfoVo productInfoVoCtrl);
    List<ProductTypeContentVo> selectType();

}
