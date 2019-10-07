package com.example.book_sell;

public class db_User {
    private String mauser;
    private String username;
    private String password;
    private String email;

    public db_User(String mauser, String username, String email, String password) {
        this.mauser = mauser;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public String getMauser() {
        return mauser;
    }

    public void setMauser(String mauser) {
        this.mauser = mauser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
