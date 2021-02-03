package entities;

import java.io.Serializable;

public class Rendez implements Serializable {

    private int id;
    private String name;
    private String date;
    private String docteur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDocteur() {
        return docteur;
    }

    public void setDocteur(String docteur) {
        this.docteur = docteur;
    }

    public Rendez(int id, String name, String date, String docteur) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.docteur = docteur;
    }

    public Rendez() {
    }
}
