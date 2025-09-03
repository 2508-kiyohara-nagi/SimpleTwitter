package chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

    private int id;
    private String text;
    private int userId;
    private int messageId;
    private Date createdDate;
    private Date updatedDate;

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

    //created_date取得して変数を使えるように
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    //updated_date取得して変数を使えるように
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}

