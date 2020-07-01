package com.hiep.model;

import java.sql.Date;

public class User {
    protected int id;
    protected String acount;
    protected String password;
    protected String address;
    protected String mail;
    protected String birthday;
    protected String sex;
    protected String id_university;

    public User(){};

    public User(String acount, String password, String address, String mail, String birthday, String sex, String id_university) {
        this.acount = acount;
        this.password = password;
        this.address = address;
        this.mail = mail;
        this.birthday = birthday;
        this.sex = sex;
        this.id_university = id_university;
    }

    public User(int id, String acount, String password, String address, String mail, String birthday, String sex, String id_university) {
        this.id = id;
        this.acount = acount;
        this.password = password;
        this.address = address;
        this.mail = mail;
        this.birthday = birthday;
        this.sex = sex;
        this.id_university = id_university;
    }

    public User(String acount, String address, String mail, String birthday, String sex, String id_university) {
        this.id = id;
        this.acount = acount;
        this.address = address;
        this.mail = mail;
        this.birthday = birthday;
        this.sex = sex;
        this.id_university = id_university;
    }

    public User(String acount, String email, String address, Date birtday, String sex, String id_university) {
    }

    public User(String acount, String address, String mail, String birthday, String sex) {
        this.acount = acount;
        this.address = address;
        this.mail = mail;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId_university() {
        return id_university;
    }

    public void setId_university(String id_university) {
        this.id_university = id_university;
    }
}
