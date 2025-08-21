package chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class UserMessage implements Serializable {

    private int id;
    private String account;
    private String name;
    private int userId;
    private String text;
    private Date createdDate;

    // getter/setterは省略されているので、自分で記述しましょう。
    //userIdを取得して変数を使えるように
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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


}
