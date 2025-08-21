package chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private int id;
    private int userId;
    private String text;
    private Date createdDate;
    private Date updatedDate;

    // getter/setterは省略されているので、自分で記述しましょう。
    //idを取得して変数を使えるように
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //
    //userIdを取得して変数を使えるように
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //textを取得して変数を使えるように
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    //createdDate取得して変数を使えるように
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    //updatedDate取得して変数を使えるように
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}