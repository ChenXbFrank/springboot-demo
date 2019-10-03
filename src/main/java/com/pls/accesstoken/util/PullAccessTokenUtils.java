package com.pls.accesstoken.util;
import com.google.gson.Gson;
import com.pls.accesstoken.model.PullAccessToken;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从网上获取的新的AccessToken的功能工具类
 * Created by 81046 on 2018-07-12
 */
public class PullAccessTokenUtils {

    public static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static String getAccessToken(String APPID, String APPSECRET) {
        url = url.replaceAll("APPID", APPID).replaceAll("APPSECRET", APPSECRET);
        URL Url = null;
        try {
            Url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String json = HttpUtils.get(Url);
        Gson gson = new Gson();
        PullAccessToken accessToken = gson.fromJson(json, PullAccessToken.class);
        return accessToken.getAccess_token();
    }
}
