package com.springapp.mvc.netResult;

/**
 * Created by eavawu on 11/15/15.
 */
public class TokenResult {
    String userId;
    String token;
    String code;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
