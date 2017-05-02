package com.jjsoluciones.segundosprint.login;

/**
 * Created by eduardoarias on 7/04/17.
 */

public class User {
    private int id;
    private String user;
    private String nameUser;
    private String password;

    public User(int id, String user, String nameUser, String password) {
        this.id = id;
        this.user = user;
        this.nameUser = nameUser;
        this.password = password;
    }

    public User() {
        this(0,"","","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
