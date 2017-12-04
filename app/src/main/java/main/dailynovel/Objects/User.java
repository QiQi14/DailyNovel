package main.dailynovel.Objects;

import java.io.Serializable;

public class User implements Serializable{

    private String userID;
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    private String userPW;
    public String getUserPW() {
        return userPW;
    }
    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userMail;
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    private String userDoB;
    public String getUserDoB() {
        return userDoB;
    }
    public void setUserDoB(String userDoB) {
        this.userDoB = userDoB;
    }

    private String userQID;
    public String getUserQID() {
        return userQID;
    }
    public void setUserQID(String userQID) {
        this.userQID = userQID;
    }

    private String userQA;
    public String getUserQA() {
        return userQA;
    }
    public void setUserQA(String userQA) {
        this.userQA = userQA;
    }

    private String userAvatar;
    public String getUserAvatar() {
        return userAvatar;
    }
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public User() {
    }

    public User(String userID, String userPW, String userName, String userMail, String userDoB, String userQID, String userQA, String userAvatar) {
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.userMail = userMail;
        this.userDoB = userDoB;
        this.userQID = userQID;
        this.userQA = userQA;
        this.userAvatar = userAvatar;
    }
}
