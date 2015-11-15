package com.springapp.mvc.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by eavawu on 11/15/15.
 */
@Entity
@Table(name = "friend", schema = "", catalog = "confidant")
public class FriendEntity implements Serializable {    private int id;
    private String account;
    private String friendAccount;
    private int isBlack;
    private int isProtect;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "friendAccount")
    public String getFriendAccount() {
        return friendAccount;
    }

    public void setFriendAccount(String friendAccount) {
        this.friendAccount = friendAccount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (id != that.id) return false;
        if (isBlack != that.isBlack) return false;
        if (isProtect != that.isProtect) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (friendAccount != null ? !friendAccount.equals(that.friendAccount) : that.friendAccount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (friendAccount != null ? friendAccount.hashCode() : 0);
        result = 31 * result + isBlack;
        result = 31 * result + isProtect;
        return result;
    }
}
