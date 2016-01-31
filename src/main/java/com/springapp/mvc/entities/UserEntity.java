package com.springapp.mvc.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by eavawu on 11/22/15.
 */
@Entity
@javax.persistence.Table(name = "user", schema = "", catalog = "confidant")
public class UserEntity {
    private String userName;

    @Basic
    @javax.persistence.Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String password;

    @Basic
    @javax.persistence.Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String birthday;

    @Basic
    @javax.persistence.Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private String habbit;

    @Basic
    @javax.persistence.Column(name = "habbit")
    public String getHabbit() {
        return habbit;
    }

    public void setHabbit(String habbit) {
        this.habbit = habbit;
    }

    private String headIcon;

    @Basic
    @javax.persistence.Column(name = "headIcon")
    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    private int sex;

    @Basic
    @javax.persistence.Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    private Float longitude;

    @Basic
    @javax.persistence.Column(name = "longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    private Float latitude;

    @Basic
    @javax.persistence.Column(name = "latitude")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    private String account;

    @Basic
    @javax.persistence.Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private int userId;

    @Id
    @javax.persistence.Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String lastlogintime;

    @Basic
    @javax.persistence.Column(name = "lastlogintime")
    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    private Integer confidantDeId;

    @Basic
    @javax.persistence.Column(name = "confidantDeId")
    public Integer getConfidantDeId() {
        return confidantDeId;
    }

    public void setConfidantDeId(Integer confidantDeId) {
        this.confidantDeId = confidantDeId;
    }

    private Integer myConfidantId;

    @Basic
    @javax.persistence.Column(name = "myConfidantId")
    public Integer getMyConfidantId() {
        return myConfidantId;
    }

    public void setMyConfidantId(Integer myConfidantId) {
        this.myConfidantId = myConfidantId;
    }

    private Integer confidantStar;

    @Basic
    @javax.persistence.Column(name = "confidantStar")
    public Integer getConfidantStar() {
        return confidantStar;
    }

    public void setConfidantStar(Integer confidantStar) {
        this.confidantStar = confidantStar;
    }

    private Integer isLogin;

    @Basic
    @javax.persistence.Column(name = "isLogin")
    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    private String token;

    @Basic
    @javax.persistence.Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private Integer money;

    @Basic
    @javax.persistence.Column(name = "money")
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    private String signature;

    @Basic
    @javax.persistence.Column(name = "signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (sex != that.sex) return false;
        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (habbit != null ? !habbit.equals(that.habbit) : that.habbit != null) return false;
        if (headIcon != null ? !headIcon.equals(that.headIcon) : that.headIcon != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (lastlogintime != null ? !lastlogintime.equals(that.lastlogintime) : that.lastlogintime != null)
            return false;
        if (confidantDeId != null ? !confidantDeId.equals(that.confidantDeId) : that.confidantDeId != null)
            return false;
        if (myConfidantId != null ? !myConfidantId.equals(that.myConfidantId) : that.myConfidantId != null)
            return false;
        if (confidantStar != null ? !confidantStar.equals(that.confidantStar) : that.confidantStar != null)
            return false;
        if (isLogin != null ? !isLogin.equals(that.isLogin) : that.isLogin != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (habbit != null ? habbit.hashCode() : 0);
        result = 31 * result + (headIcon != null ? headIcon.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (lastlogintime != null ? lastlogintime.hashCode() : 0);
        result = 31 * result + (confidantDeId != null ? confidantDeId.hashCode() : 0);
        result = 31 * result + (myConfidantId != null ? myConfidantId.hashCode() : 0);
        result = 31 * result + (confidantStar != null ? confidantStar.hashCode() : 0);
        result = 31 * result + (isLogin != null ? isLogin.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        return result;
    }
}
