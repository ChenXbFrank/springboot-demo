package com.pls.accesstoken.schedule;

import com.pls.accesstoken.model.AccessTokens;
import com.pls.accesstoken.model.SellerPublicNumber;
import com.pls.accesstoken.service.AccessTokenService;
import com.pls.accesstoken.service.SellerPublicService;
import com.pls.accesstoken.util.DateUtil;
import com.pls.accesstoken.util.PullAccessTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 定时器实现类
 * Created by 81046 on 2018-07-12
 */
@Component
public class ScheduledTasks {

    private final static Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    @Autowired
    private SellerPublicService sellerPublicService;

    @Autowired
    private AccessTokenService accessTokenService;

    /**
     * 项目运行后的每5秒一次
     * 5000 --> 5s
     * 这里需要每7000s 去更新数据库所有的accessToken   7000000 ms
     */
    @Scheduled(fixedRate = 500000)
    public void updateAccessToken() {
        String time = DateUtil.format(new Date());
        log.info("这里需要每5000s 去更新数据库所有的accessToken："+ time);
        List<SellerPublicNumber> list = sellerPublicService.getAllList();
        for ( SellerPublicNumber sellerPublicNumber: list) {
            String appid = sellerPublicNumber.getAppid();
            String publicNumberName = sellerPublicNumber.getPublicNumberName();
            //先根据appid查询该对象，如果为空的话，则保存
            AccessTokens accessTokenByAppId = accessTokenService.getAccessTokenByAppId(appid);
            String accessToken = PullAccessTokenUtils.getAccessToken(appid, sellerPublicNumber.getAppsecret());
            log.info("获取新的token成功："+accessToken);
            if(accessTokenByAppId==null){
                accessTokenService.save(appid,accessToken,time,publicNumberName);
                log.info("保存token成功,保存的token："+accessToken);
            }
            //相当于已经存了，现在直接更新
            else{
                int i = accessTokenService.updateAccessTokensByAppId(accessToken,time,publicNumberName,appid);
                if(i>0){
                    log.info("更新token成功,保存的token："+accessToken);
                }
            }
        }
    }

}
