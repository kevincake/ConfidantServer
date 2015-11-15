package com.springapp.mvc.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by eavawu on 11/15/15.
 */
@Entity
@Table(name = "gift", schema = "", catalog = "confidant")
public class GiftEntity implements Serializable {    private Integer count;
    private String toAccount;
    private Integer itemId;
    private int id;
    private String account;

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "toAccount")
    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    @Basic
    @Column(name = "itemId")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GiftEntity that = (GiftEntity) o;

        if (id != that.id) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (toAccount != null ? !toAccount.equals(that.toAccount) : that.toAccount != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = count != null ? count.hashCode() : 0;
        result = 31 * result + (toAccount != null ? toAccount.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}
