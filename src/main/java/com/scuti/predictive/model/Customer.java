package com.scuti.predictive.model;

/**
 * Created by kkataria on 8/20/2016.
 */
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {


    public String id;
    public String email;
    public String userName;
    public String password;
    public String hint;
    public String hintAnswer;
    public String guest;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHintAnswer() {
        return hintAnswer;
    }

    public void setHintAnswer(String hintAnswer) {
        this.hintAnswer = hintAnswer;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }
}