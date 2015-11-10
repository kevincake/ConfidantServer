package com.springapp.mvc.entities;

import javax.persistence.*;

/**
 * Created by glpublic on 2015/11/10.
 */
@Entity
@Table(name = "user", schema = "", catalog = "confidant")
public class UserEntity {
    private String userName;
    private String password;
    private String birthday;
    private String habbit;
    private String headIcon;
    private int sex;
    private Float longitude;
    private float latitude;
    private String account;
    private int userId;
    private String lastlogintime;
    private Integer confidantDeId;
    private int myConfidantId;
    private Integer confidantStar;

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "habbit")
    public String getHabbit() {
        return habbit;
    }

    public void setHabbit(String habbit) {
        this.habbit = habbit;
    }

    @Basic
    @Column(name = "headIcon")
    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    @Basic
    @Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "lastlogintime")
    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Basic
    @Column(name = "confidantDeId")
    public Integer getConfidantDeId() {
        return confidantDeId;
    }

    public void setConfidantDeId(Integer confidantDeId) {
        this.confidantDeId = confidantDeId;
    }

    @Basic
    @Column(name = "myConfidantId")
    public int getMyConfidantId() {
        return myConfidantId;
    }

    public void setMyConfidantId(int myConfidantId) {
        this.myConfidantId = myConfidantId;
    }

    @Basic
    @Column(name = "confidantStar")
    public Integer getConfidantStar() {
        return confidantStar;
    }

    public void setConfidantStar(Integer confidantStar) {
        this.confidantStar = confidantStar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (sex != that.sex) return false;
        if (Float.compare(that.latitude, latitude) != 0) return false;
        if (userId != that.userId) return false;
        if (myConfidantId != that.myConfidantId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (habbit != null ? !habbit.equals(that.habbit) : that.habbit != null) return false;
        if (headIcon != null ? !headIcon.equals(that.headIcon) : that.headIcon != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (lastlogintime != null ? !lastlogintime.equals(that.lastlogintime) : that.lastlogintime != null)
            return false;
        if (confidantDeId != null ? !confidantDeId.equals(that.confidantDeId) : that.confidantDeId != null)
            return false;
        if (confidantStar != null ? !confidantStar.equals(that.confidantStar) : that.confidantStar != null)
            return false;

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
        result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (lastlogintime != null ? lastlogintime.hashCode() : 0);
        result = 31 * result + (confidantDeId != null ? confidantDeId.hashCode() : 0);
        result = 31 * result + myConfidantId;
        result = 31 * result + (confidantStar != null ? confidantStar.hashCode() : 0);
        return result;
    }
}
