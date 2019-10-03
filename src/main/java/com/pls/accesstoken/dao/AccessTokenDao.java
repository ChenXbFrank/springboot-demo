package com.pls.accesstoken.dao;

import com.pls.accesstoken.model.AccessTokens;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * 这里是处理accessToken的数据交互层
 * Created by 81046 on 2018-07-12
 */
public interface AccessTokenDao {
    /**
     * 根據APPID查詢AccessTokens
     * @param appid
     * @return
     * //TODO 这种方式查不出对象的原因是没有将对象属性和表列名一一对应，导致最后查询出来映射不上来，结果就为空了
     * //TODO 解决方法：在mapper文件中实现并解决了该问题
     */
    @Select("select * from TB_ACCESS_TOKENS where appid = #{appid}")
    //TODO  解决了上面所述问题  越来越多的坑 嘻嘻
    @Results({
            @Result(property="appid",column="APPID"),
            @Result(property="accessToken",column="ACCESS_TOKEN"),
            @Result(property="saveTime",column="SAVE_TIME"),
            @Result(property="sellerPublicName",column="SELLER_PUBLIC_NAME"
            )
    })
    AccessTokens getAccessTokenByAppId(@Param("appid")String appid);

    /**
     * 根據APPID查詢AccessToken
     * @param appid
     * @return
     */
    @Select("select access_token from TB_ACCESS_TOKENS where appid = #{appid}")
    String getTokenByAppId(@Param("appid")String appid);

    /**
     * 插入新的AccessTokens
     * @param appid
     * @param accessToken
     * @param saveTime
     */
    @Insert("insert into TB_ACCESS_TOKENS(appid,access_token,save_time,seller_public_name) values(#{appid},#{accessToken},#{saveTime},#{sellerPublicName})")
    @Options(useGeneratedKeys = true, keyProperty = "appid", keyColumn = "appid")
    @Transactional
    void save(@Param("appid") String appid,@Param("accessToken")String accessToken, @Param("saveTime")String saveTime, @Param("sellerPublicName")String sellerPublicName);

    /**
     * 根据APPID修改AccessTokens
     * @param accessToken
     * @param saveTime
     * @param appid
     * @return
     */
    @Transactional
    @Update({ "update TB_ACCESS_TOKENS set access_token = #{accessToken},save_time = #{saveTime},seller_public_name = #{sellerPublicName} where appid = #{appid}" })
    int updateAccessTokensByAppId(@Param("accessToken")String accessToken, @Param("saveTime")String saveTime,@Param("sellerPublicName")String sellerPublicName,@Param("appid") String appid);

    /**
     * 根据appid查询accessTokens对象
     */
    AccessTokens findByAppId(@Param("appid")String appid);

    /**
     * 根据appid查询accessTokens对象的accessToken值
     */
    String findAccessByAppId(@Param("appid")String appid);

}
