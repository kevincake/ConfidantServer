package com.springapp.mvc.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by eavawu on 11/15/15.
 */
@Entity
@Table(name = "chat", schema = "", catalog = "confidant")
public class ChatEntity implements Serializable {    private String account;
    private Integer chatType;
    private Integer voiceTime;
    private Integer videoTime;
    private Integer textTime;
    private String token;
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
    @Column(name = "chatType")
    public Integer getChatType() {
        return chatType;
    }

    public void setChatType(Integer chatType) {
        this.chatType = chatType;
    }

    @Basic
    @Column(name = "voiceTime")
    public Integer getVoiceTime() {
        return voiceTime;
    }

    public void setVoiceTime(Integer voiceTime) {
        this.voiceTime = voiceTime;
    }

    @Basic
    @Column(name = "videoTime")
    public Integer getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    @Basic
    @Column(name = "textTime")
    public Integer getTextTime() {
        return textTime;
    }

    public void setTextTime(Integer textTime) {
        this.textTime = textTime;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

        ChatEntity that = (ChatEntity) o;

        if (id != that.id) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (chatType != null ? !chatType.equals(that.chatType) : that.chatType != null) return false;
        if (voiceTime != null ? !voiceTime.equals(that.voiceTime) : that.voiceTime != null) return false;
        if (videoTime != null ? !videoTime.equals(that.videoTime) : that.videoTime != null) return false;
        if (textTime != null ? !textTime.equals(that.textTime) : that.textTime != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (chatType != null ? chatType.hashCode() : 0);
        result = 31 * result + (voiceTime != null ? voiceTime.hashCode() : 0);
        result = 31 * result + (videoTime != null ? videoTime.hashCode() : 0);
        result = 31 * result + (textTime != null ? textTime.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
