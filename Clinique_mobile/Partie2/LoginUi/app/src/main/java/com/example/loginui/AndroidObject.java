package com.example.loginui;

import java.io.Serializable;

public class AndroidObject implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private String maladie;
    private String phone1;
    private String phone2;
    private String etat;

    public AndroidObject(String name, String maladie,String etat, String phone1, String phone2) {

        this.name = name;
        this.maladie = maladie;
        this.etat = etat;
        this.phone1 = phone1;
        this.phone2 = phone2;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String specialty) {
        this.maladie = maladie;
    }

    public String getEtat() { return etat; }

    public void setMail(String mail) {
        this.etat = etat;
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


}

