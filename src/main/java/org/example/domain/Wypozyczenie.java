/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.domain;

/**
 *
 * @author 48514
 */
public abstract class Wypozyczenie {

    private String nazwa;
    private int wiekMinimalny;
    private Klient klient;

    public String getNazwa() {
        return nazwa;
    }

    public int getWiekMinimalny() {
        return wiekMinimalny;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setWiekMinimalny(int wiekMinimalny) {
        this.wiekMinimalny = wiekMinimalny;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
    
    
}
