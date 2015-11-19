package com.springapp.mvc.model;

/**
 * Created by glpublic on 2015/11/19.
 */
public class Recharge {
    int id;
    int price;
    int firstGet;
    String name;
    String des;
    String smallIcon;
    String bigIcon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFirstGet() {
        return firstGet;
    }

    public void setFirstGet(int firstGet) {
        this.firstGet = firstGet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
    }

    public String getBigIcon() {
        return bigIcon;
    }

    public void setBigIcon(String bigIcon) {
        this.bigIcon = bigIcon;
    }
}
