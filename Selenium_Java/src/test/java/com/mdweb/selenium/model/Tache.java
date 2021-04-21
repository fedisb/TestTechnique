package com.mdweb.selenium.model;

public class Tache {

    private String nomTache;
    private String desciptionTache;

    public Tache generateDefaultTache() {

        Tache tache = new Tache();
        tache.setNomTache("Test_Tache");
        tache.setDesciptionTache("testtest");

        return tache;

    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getDesciptionTache() {
        return desciptionTache;
    }

    public void setDesciptionTache(String desciptionTache) {
        this.desciptionTache = desciptionTache;
    }

}