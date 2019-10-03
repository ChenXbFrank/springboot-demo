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
@Table(name = "TB_SELLER_PUBLICNUMBER")
public class SellerPublicNumber implements Serializable{
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "PUBLICNUMBER_NAME")
    private String publicNumberName;

    @Column(name = "APPID")
    private String appid;

    @Column(name = "APPSECRET")
    private String appsecret;

    @Column(name = "PUBLICNUMBER_QRCODE_IMG")
    private String publicNumberQrcodeImg;

    @Column(name = "SHOP_NUMBER")
    private String shopNumber;

    @Column(name = "PAY_KEY")
    private String payKey;

    @Column(name = "WINNING_NEWS_ID")
    private String winningNewsId;

    @Column(name = "SELLER_USERCODE")
    private String sellerUsercode;

    @Column(name = "SELLER_USERID")
    private String sellerUserId;

    @Column(name = "SPARE_ONE")
    private String spareOne;

    @Column(name = "SPARE_TWO")
    private String spareTwo;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "SENDERNAME")
    private String senderName;

    @Column(name = "WISH")
    private String wish;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "SENDID")
    private String sendId;

    @Column(name = "SUCCESSID")
    private String successId;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "SCAN_IMG")
    private String scanImg;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "PHONE")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicNumberName() {
        return publicNumberName;
    }

    public void setPublicNumberName(String publicNumberName) {
        this.publicNumberName = publicNumberName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getPublicNumberQrcodeImg() {
        return publicNumberQrcodeImg;
    }

    public void setPublicNumberQrcodeImg(String publicNumberQrcodeImg) {
        this.publicNumberQrcodeImg = publicNumberQrcodeImg;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public String getWinningNewsId() {
        return winningNewsId;
    }

    public void setWinningNewsId(String winningNewsId) {
        this.winningNewsId = winningNewsId;
    }

    public String getSellerUsercode() {
        return sellerUsercode;
    }

    public void setSellerUsercode(String sellerUsercode) {
        this.sellerUsercode = sellerUsercode;
    }

    public String getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(String sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public String getSpareOne() {
        return spareOne;
    }

    public void setSpareOne(String spareOne) {
        this.spareOne = spareOne;
    }

    public String getSpareTwo() {
        return spareTwo;
    }

    public void setSpareTwo(String spareTwo) {
        this.spareTwo = spareTwo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getSuccessId() {
        return successId;
    }

    public void setSuccessId(String successId) {
        this.successId = successId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getScanImg() {
        return scanImg;
    }

    public void setScanImg(String scanImg) {
        this.scanImg = scanImg;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SellerPublicNumber() {
    }

    @Override
    public String toString() {
        return "SellerPublicNumber{" +
                "id='" + id + '\'' +
                ", publicNumberName='" + publicNumberName + '\'' +
                ", appid='" + appid + '\'' +
                ", appsecret='" + appsecret + '\'' +
                ", publicNumberQrcodeImg='" + publicNumberQrcodeImg + '\'' +
                ", shopNumber='" + shopNumber + '\'' +
                ", payKey='" + payKey + '\'' +
                ", winningNewsId='" + winningNewsId + '\'' +
                ", sellerUsercode='" + sellerUsercode + '\'' +
                ", sellerUserId='" + sellerUserId + '\'' +
                ", spareOne='" + spareOne + '\'' +
                ", spareTwo='" + spareTwo + '\'' +
                ", token='" + token + '\'' +
                ", senderName='" + senderName + '\'' +
                ", wish='" + wish + '\'' +
                ", remarks='" + remarks + '\'' +
                ", sendId='" + sendId + '\'' +
                ", successId='" + successId + '\'' +
                ", company='" + company + '\'' +
                ", scanImg='" + scanImg + '\'' +
                ", logo='" + logo + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
