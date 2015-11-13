package com.springapp.mvc.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by glpublic on 2015/11/13.
 */
@Entity
@Table(name = "friend", schema = "", catalog = "confidant")
public class FriendEntity implements Serializable {    private int id;
    private Integer userId;
    private int friendId;
    private int isBlack;
    private int isProtect;
    private String lastlogintime;
    private Integer rechargeMoney;
    private Integer costMoney;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "friendId")
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Basic
    @Column(name = "isBlack")
    public int getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(int isBlack) {
        this.isBlack = isBlack;
    }

    @Basic
    @Column(name = "isProtect")
    public int getIsProtect() {
        return isProtect;
    }

    public void setIsProtect(int isProtect) {
        this.isProtect = isProtect;
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
    @Column(name = "rechargeMoney")
    public Integer getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Integer rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    @Basic
    @Column(name = "costMoney")
    public Integer getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Integer costMoney) {
        this.costMoney = costMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (id != that.id) return false;
        if (friendId != that.friendId) return false;
        if (isBlack != that.isBlack) return false;
        if (isProtect != that.isProtect) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (lastlogintime != null ? !lastlogintime.equals(that.lastlogintime) : that.lastlogintime != null)
            return false;
        if (rechargeMoney != null ? !rechargeMoney.equals(that.rechargeMoney) : that.rechargeMoney != null)
            return false;
        if (costMoney != null ? !costMoney.equals(that.costMoney) : that.costMoney != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + friendId;
        result = 31 * result + isBlack;
        result = 31 * result + isProtect;
        result = 31 * result + (lastlogintime != null ? lastlogintime.hashCode() : 0);
        result = 31 * result + (rechargeMoney != null ? rechargeMoney.hashCode() : 0);
        result = 31 * result + (costMoney != null ? costMoney.hashCode() : 0);
        return result;
    }
}
