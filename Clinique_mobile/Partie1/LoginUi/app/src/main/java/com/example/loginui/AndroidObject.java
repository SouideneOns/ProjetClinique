package com.example.loginui;

import java.io.Serializable;

public class AndroidObject implements Serializable {
    private static final long serialVersionUID=1L;


    public AndroidObject(String name, String specialty, String phone1, String phone2, String mail) {

        this.name = name;
        this.specialty = specialty;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.mail = mail;

    }

    private String name;
    private String specialty;
    private String phone1;
    private String phone2;
    private String mail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

