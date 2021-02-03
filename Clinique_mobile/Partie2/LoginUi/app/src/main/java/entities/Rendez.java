package entities;

import java.io.Serializable;

public class Rendez implements Serializable {

    private int id;
    private String name;
    private String date;
    private String etat;

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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Rendez() {
    }

    public Rendez(int id, String name, String date, String etat) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.etat = etat;
    }
}
