package com.pls.accesstoken.dao;

import com.pls.accesstoken.model.SellerPublicNumber;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 81046 on 2018-07-12
 */
public interface SellerPublicDao {

    /**
     * 这里查询所有的公众号信息，select *   只会自动映射属性和列名一样的值，如果需要全部的值，需要自己手动添加映射值在Results里面的
     * @return
     */
    @Select("select * from TB_SELLER_PUBLICNUMBER")
    @Results({
            @Result(property="id",column="ID"),
            @Result(property="publicNumberName",column="PUBLICNUMBER_NAME"),
            @Result(property="appid",column="APPID"),
            @Result(property="appsecret",column="APPSECRET"),
            @Result(property="shopNumber",column="SHOP_NUMBER"),
            @Result(property="payKey",column="PAY_KEY"),
            @Result(property="company",column="COMPANY"),
            @Result(property="token",column="TOKEN")
    })
    List<SellerPublicNumber> getAllList();

}
