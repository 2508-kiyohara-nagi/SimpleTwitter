package chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class UserComment implements Serializable {

    private int id;
    private String text;
    private int userId;
    private int messageId;
    private String account;
    private String name;
    private Date createdDate;

    //idを取得して変数を使えるように
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //textを取得して変数を使えるように
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    //user_idを取得して変数を使えるように
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //message_idを取得して変数を使えるように
    public int getMessageId() {
        return messageId;
    }
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    //accountを取得して変数を使えるように
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    //nameを取得して変数を使えるように
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //createdDate取得して変数を使えるように
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
