package com.example.proyectoinicio;

public class User {

    private long id;
    private String mail;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String mail, String password) {
        this(0, mail, password);
    }

    public User(long id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }
}
