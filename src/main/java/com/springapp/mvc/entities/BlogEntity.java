package com.springapp.mvc.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by eavawu on 11/15/15.
 */
@Entity
@Table(name = "blog", schema = "", catalog = "confidant")
public class BlogEntity implements Serializable {    private String account;
    private String msgText;
    private Integer photo1;
    private String time;
    private String photo2;
    private String photo3;
    private String photo4;
    private String photo5;
    private String photo6;
    private Integer heartType;
    private String mobileName;
    private String location;
    private int id;

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "msgText")
    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Basic
    @Column(name = "photo1")
    public Integer getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Integer photo1) {
        this.photo1 = photo1;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "photo2")
    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    @Basic
    @Column(name = "photo3")
    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    @Basic
    @Column(name = "photo4")
    public String getPhoto4() {
        return photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    @Basic
    @Column(name = "photo5")
    public String getPhoto5() {
        return photo5;
    }

    public void setPhoto5(String photo5) {
        this.photo5 = photo5;
    }

    @Basic
    @Column(name = "photo6")
    public String getPhoto6() {
        return photo6;
    }

    public void setPhoto6(String photo6) {
        this.photo6 = photo6;
    }

    @Basic
    @Column(name = "heartType")
    public Integer getHeartType() {
        return heartType;
    }

    public void setHeartType(Integer heartType) {
        this.heartType = heartType;
    }

    @Basic
    @Column(name = "mobileName")
    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

        if (id != that.id) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (msgText != null ? !msgText.equals(that.msgText) : that.msgText != null) return false;
        if (photo1 != null ? !photo1.equals(that.photo1) : that.photo1 != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (photo2 != null ? !photo2.equals(that.photo2) : that.photo2 != null) return false;
        if (photo3 != null ? !photo3.equals(that.photo3) : that.photo3 != null) return false;
        if (photo4 != null ? !photo4.equals(that.photo4) : that.photo4 != null) return false;
        if (photo5 != null ? !photo5.equals(that.photo5) : that.photo5 != null) return false;
        if (photo6 != null ? !photo6.equals(that.photo6) : that.photo6 != null) return false;
        if (heartType != null ? !heartType.equals(that.heartType) : that.heartType != null) return false;
        if (mobileName != null ? !mobileName.equals(that.mobileName) : that.mobileName != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (msgText != null ? msgText.hashCode() : 0);
        result = 31 * result + (photo1 != null ? photo1.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (photo2 != null ? photo2.hashCode() : 0);
        result = 31 * result + (photo3 != null ? photo3.hashCode() : 0);
        result = 31 * result + (photo4 != null ? photo4.hashCode() : 0);
        result = 31 * result + (photo5 != null ? photo5.hashCode() : 0);
        result = 31 * result + (photo6 != null ? photo6.hashCode() : 0);
        result = 31 * result + (heartType != null ? heartType.hashCode() : 0);
        result = 31 * result + (mobileName != null ? mobileName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
