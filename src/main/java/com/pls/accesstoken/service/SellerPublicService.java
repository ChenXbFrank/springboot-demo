package com.pls.accesstoken.service;

import com.pls.accesstoken.dao.SellerPublicDao;
import com.pls.accesstoken.model.AccessTokens;
import com.pls.accesstoken.model.SellerPublicNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 获取公众号信息service
 * Created by 81046 on 2018-07-12
 */
@Service
public class SellerPublicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenService.class);

    @Autowired
    private SellerPublicDao sellerPublicDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<SellerPublicNumber> getAllList(){
        // 从缓存中获取accesstoken信息
        String key = "sellerPublicNumberList";
        ValueOperations<String, List<SellerPublicNumber>> operations = redisTemplate.opsForValue();

        // 缓存存在  直接返回
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<SellerPublicNumber> sellerPublicNumberList = operations.get(key);
            LOGGER.info("AccessTokenService.getAccessTokenByAppId() : 从缓存中获取了accesstoken >> " + sellerPublicNumberList.toString());
            return sellerPublicNumberList;
        }

        // 从 DB 中获取accesstoken信息
        List<SellerPublicNumber> sellerPublicNumberList = sellerPublicDao.getAllList();
        // 插入缓存
        operations.set(key, sellerPublicNumberList, 1000, TimeUnit.SECONDS);
        LOGGER.info("AccessTokenService.getAccessTokenByAppId() : accesstoken插入缓存 >> " + sellerPublicNumberList.toString());
        return sellerPublicNumberList;
    }
}
