package com.example.easylearning.sqlitedatabase;

import android.provider.BaseColumns;

public class User {

    public static final class UserDetails implements BaseColumns{
        public static final String TABLE_NAME="userregister";
        public static final String COL_ID="id";
        public static final String COL_NAME="name";
        public static final String COL_EMAIL="email";
        public static final String COL_PASS ="pass";
    }
    private int id;
    private String name;
    private String email;
    private String pass;

    public User() {
    }

    public User(int id, String name, String email, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public User(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
