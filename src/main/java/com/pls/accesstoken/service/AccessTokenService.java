package com.pls.accesstoken.service;

import com.pls.accesstoken.dao.AccessTokenDao;
import com.pls.accesstoken.model.AccessTokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取数据库里面的token service
 * Created by 81046 on 2018-07-12
 */
@Service
public class AccessTokenService {

    @Autowired
    private AccessTokenDao accessTokenDao;

    /**
     * 根据appid获取accesstoken
     * @param appid
     * @return
     *  192.168.0.3:8089/home/getAccessTokenByAppId?appid=wx3db6ea684d097397
     */
    public AccessTokens getAccessTokenByAppId(String appid){
        return accessTokenDao.getAccessTokenByAppId(appid);
    }

    /**
     * 根據APPID查詢AccessToken
     * @param appid
     * @return
     */
    public String getTokenByAppId(String appid){
        return accessTokenDao.getTokenByAppId(appid);
    }

    /**
     * 保存新的accessTokens对象
     * @param appid
     * @param accessToken
     * @param saveTime
     */
    public void save(String appid,String accessToken,String saveTime,String sellerPublicName ){
        accessTokenDao.save(appid,accessToken,saveTime,sellerPublicName);
    }

    /**
     * 根据APPID修改AccessTokens
     * @param accessToken
     * @param saveTime
     * @param appid
     * @return
     */
    public int updateAccessTokensByAppId(String accessToken,String saveTime,String sellerPublicName,String appid){
        return accessTokenDao.updateAccessTokensByAppId(accessToken, saveTime,sellerPublicName, appid);
    }

    /**
     * 根據APPID查詢AccessToken  xml为文件
     * @param appid
     * @return
     */
    public AccessTokens findByAppId(String appid){
        return accessTokenDao.findByAppId(appid);
    }

    /**
     * 根据appid直接查询accessToken  xml文件
     * @param appid
     * @return
     */
    public String findAccessByAppId(String appid){
        return accessTokenDao.findAccessByAppId(appid);
    }
}
