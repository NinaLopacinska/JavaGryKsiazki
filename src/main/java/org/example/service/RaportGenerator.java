/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;

import org.example.baza.BazaWypozyczen;
import org.example.domain.Gra;
import org.example.domain.Ksiazka;
import org.example.domain.Wypozyczenie;

/**
 *
 * @author 48514
 */
public class RaportGenerator implements IRaport{
    @Override
    public void generujRaport(BazaWypozyczen bazaWypozyczen) {
        int liczbaKsiazek = 0;
        int liczbaGier = 0;
        int dzieci = 0;
        int mlodziez = 0;
        int dorosli = 0;

        for (Wypozyczenie wypozyczenie : bazaWypozyczen.getWypozyczenia()) {
            if (wypozyczenie instanceof Ksiazka) {
                liczbaKsiazek++;
            } else if (wypozyczenie instanceof Gra) {
                liczbaGier++;
            }

            int wiekKlienta = wypozyczenie.getKlient().getWiek();

            if (wiekKlienta <= 10) {
                dzieci++;
            } else if (wiekKlienta <= 17) {
                mlodziez++;
            } else {
                dorosli++;
            }
        }

        System.out.println("Raport:");
        System.out.println("Liczba wypozyczonych ksiazek: " + liczbaKsiazek);
        System.out.println("Liczba wypozyczonych gier: " + liczbaGier);
        System.out.println("Liczba wypozyczen dzieci (do lat 10): " + dzieci);
        System.out.println("Liczba wypozyczen mlodziezy (11 - 17 lat): " + mlodziez);
        System.out.println("Liczba wypozyczen dorosłych (18+): " + dorosli);
    }
}
