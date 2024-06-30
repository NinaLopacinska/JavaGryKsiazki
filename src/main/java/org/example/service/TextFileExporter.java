/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.service;


import org.example.domain.Gra;
import org.example.domain.Ksiazka;
import org.example.domain.Wypozyczenie;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author 48514
 */
public class TextFileExporter implements Exporter{
    @Override
    public void export(List<Wypozyczenie> wypozyczenia, String nazwaPliku) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nazwaPliku))) {
            for (Wypozyczenie wypozyczenie : wypozyczenia) {
                if (wypozyczenie instanceof Ksiazka) {
                    Ksiazka ksiazka = (Ksiazka) wypozyczenie;
                    writer.println("Ksiazka: " + ksiazka.getNazwa() + " | Autor: " + ksiazka.getAutor() +
                                   " | Klient: " + ksiazka.getKlient().getImie() + " " +
                                   ksiazka.getKlient().getNazwisko() + " | Wiek: " +
                                   ksiazka.getKlient().getWiek());
                } else if (wypozyczenie instanceof Gra) {
                    Gra gra = (Gra) wypozyczenie;
                    writer.println("Gra: " + gra.getNazwa() + " | Klient: " + gra.getKlient().getImie() + " " +
                                   gra.getKlient().getNazwisko() + " | Wiek: " + gra.getKlient().getWiek());
                }
            }
        }
    }
}
