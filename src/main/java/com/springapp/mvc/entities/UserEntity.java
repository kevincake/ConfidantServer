package com.springapp.mvc.entities;

import javax.persistence.*;

/**
 * Created by glpublic on 2015/11/3.
 */
@Entity
@Table(name = "user", schema = "", catalog = "confidant")
public class UserEntity {
    private String userName;
    private String password;
    private String birthday;
    private String habbit;
    private String headIcon;
    private String friends;
    private long id;
    private int sex;
    private float longitude;
    private float latitude;
    private String account;

    public void setId(Integer id) {
        this.id = id;
    }

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
    @Column(name = "friends")
    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    @Basic
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (habbit != null ? !habbit.equals(that.habbit) : that.habbit != null) return false;
        if (headIcon != null ? !headIcon.equals(that.headIcon) : that.headIcon != null) return false;
        if (friends != null ? !friends.equals(that.friends) : that.friends != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (habbit != null ? habbit.hashCode() : 0);
        result = 31 * result + (headIcon != null ? headIcon.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
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
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
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
}
