package com.xh.vdcluster.authenication;

import com.xh.vdcluster.common.DateUtils;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bloom on 2017/7/16.
 */
public class TokenFactory {

    private static CopyOnWriteArrayList<Token> tokens = new CopyOnWriteArrayList<Token>();
    /**
     * 获取口令
     * @param duration 有效时间，单位毫秒
     * @return
     */
    public static Token getToken(int duration){
        String tokenstr = TokenProcessor.generateTokeCode();

        Date expireDate = DateUtils.getFromMills(System.currentTimeMillis()+duration*1000);

        Token token = new Token(tokenstr,expireDate);
        
        tokens.add(token);

        return token;
    }

    /**
     * 获取口令
     * @return
     */
    public static Token getToken(){
        return getToken(300);
    }
}
