package com.pls.accesstoken.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 81046 on 2018-07-12
 */
@Entity
@Table(name = "TB_ACCESS_TOKENS")
public class AccessTokens implements Serializable{

    @Id
    @Column(name = "APPID")
    private String appid;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "SAVE_TIME")
    private String saveTime;

    @Column(name = "SELLER_PUBLIC_NAME")
    private String sellerPublicName;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSellerPublicName() {
        return sellerPublicName;
    }

    public void setSellerPublicName(String sellerPublicName) {
        this.sellerPublicName = sellerPublicName;
    }

    public AccessTokens() {
    }

    @Override
    public String toString() {
        return "AccessTokens{" +
                "appid='" + appid + '\'' +
                ", saveTime='" + saveTime + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
