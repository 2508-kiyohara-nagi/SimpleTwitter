package chapter6.beans;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int id;
    private String account;
    private String name;
    private String email;
    private String password;
    private String description;
    private Date createdDate;
    private Date updatedDate;

    // getter/setterは省略されているので、自分で記述しましょう。
    //idを取得して書き換え
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
    //emailを取得して変数を使えるように
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //passwordを取得して変数を使えるように
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //description取得して変数を使えるように
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //createdDate取得して変数を使えるように
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    //updatedDate
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


}