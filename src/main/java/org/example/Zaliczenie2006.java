/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.example;

import org.example.baza.BazaWypozyczen;
import org.example.domain.Gra;
import org.example.domain.Klient;
import org.example.domain.Ksiazka;
import org.example.domain.Wypozyczenie;
import org.example.service.Exporter;
import org.example.service.IRaport;
import org.example.service.RaportGenerator;
import org.example.service.TextFileExporter;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class for the library management system. Author: 48514
 */
public class Zaliczenie2006 {

    public static void main(String[] args) {
        System.out.println("Witaj w bibliotece!");
        Scanner scanner = new Scanner(System.in);
        boolean wantExit = false;
        Exporter exporter = new TextFileExporter();
        BazaWypozyczen bazaWypozyczen = new BazaWypozyczen();
        IRaport raportGenerator = new RaportGenerator();

        while (!wantExit) {
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Dodaj nową pozycje");
            System.out.println("2. Wyswietl liste wypozyczen");
            System.out.println("3. Generuj raport");
            System.out.println("4. Zapisz do pliku");
            System.out.println("5. Opusc biuro podrozy");

            if (scanner.hasNextInt()) {
                int optionNumber = scanner.nextInt();
                scanner.nextLine();
                switch (optionNumber) {
                    case 1:
                        System.out.println("Wybierz typ pozycji (1 - Ksika, 2 - Gra): ");
                        int typPozycji = scanner.nextInt();
                        scanner.nextLine();
                        if (typPozycji == 1) {
                            // Dodaj nową książkę
                            boolean poprawnaNazwaKsiazki = false;
                            String nazwaKsiazki;
                            do {
                                System.out.print("Podaj nazwę książki: ");
                                nazwaKsiazki = scanner.nextLine();
                                if (nazwaKsiazki.equals("") || nazwaKsiazki.length() > 120) {
                                    System.out.println("Błędna wartość dla nazwy książki!");
                                } else {
                                    poprawnaNazwaKsiazki = true;
                                }
                            } while (!poprawnaNazwaKsiazki);

                            boolean poprawnyAutor = false;
                            String autor;
                            do {
                                System.out.print("Podaj autora: ");
                                autor = scanner.nextLine();
                                if (autor.equals("") || autor.length() > 100) {
                                    System.out.println("Błędna wartość dla autora!");
                                } else {
                                    poprawnyAutor = true;
                                }
                            } while (!poprawnyAutor);

                            int wiekMinimalny;
                            do {
                                System.out.print("Podaj minimalny wiek: ");
                                if (scanner.hasNextInt()) {
                                    wiekMinimalny = scanner.nextInt();
                                    if (wiekMinimalny <= 0 || wiekMinimalny > 150) {
                                        System.out.println("Błędna wartość dla minimalnego wieku!");
                                        scanner.nextLine(); // consume newline
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Błędna wartość dla minimalnego wieku!");
                                    scanner.next(); // consume invalid input
                                }
                            } while (true);
                            scanner.nextLine(); // consume newline after reading int

                            boolean poprawneImie = false;
                            String imieKlienta;
                            do {
                                System.out.print("Podaj imię klienta: ");
                                imieKlienta = scanner.nextLine();
                                if (imieKlienta.equals("") || imieKlienta.length() > 50) {
                                    System.out.println("Błędna wartość dla imienia klienta!");
                                } else {
                                    poprawneImie = true;
                                }
                            } while (!poprawneImie);

                            boolean poprawneNazwisko = false;
                            String nazwiskoKlienta;
                            do {
                                System.out.print("Podaj nazwisko klienta: ");
                                nazwiskoKlienta = scanner.nextLine();
                                if (nazwiskoKlienta.equals("") || nazwiskoKlienta.length() > 50) {
                                    System.out.println("Błędna wartość dla nazwiska klienta!");
                                } else {
                                    poprawneNazwisko = true;
                                }
                            } while (!poprawneNazwisko);

                            int wiekKlienta;
                            do {
                                System.out.print("Podaj wiek klienta: ");
                                if (scanner.hasNextInt()) {
                                    wiekKlienta = scanner.nextInt();
                                    if (wiekKlienta <= 0 || wiekKlienta > 150) {
                                        System.out.println("Błędna wartość dla wieku klienta!");
                                        scanner.nextLine(); // consume newline
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Błędna wartość dla wieku klienta!");
                                    scanner.next(); // consume invalid input
                                }
                            } while (true);
                            scanner.nextLine(); // consume newline after reading int

                            // Tworzenie nowej książki i klienta
                            Ksiazka ksiazka = new Ksiazka();
                            ksiazka.setAutor(autor);
                            ksiazka.setNazwa(nazwaKsiazki);
                            ksiazka.setWiekMinimalny(wiekMinimalny);

                            Klient klient = new Klient();
                            klient.setImie(imieKlienta);
                            klient.setNazwisko(nazwiskoKlienta);
                            klient.setWiek(wiekKlienta);

                            ksiazka.setKlient(klient);
                            if (klient.getWiek() < ksiazka.getWiekMinimalny()) {
                                System.out.println("Jestes za młody na wypozyczenie tej ksiazki!");
                            } else {
                                bazaWypozyczen.getWypozyczenia().add(ksiazka);
                            }

                        } else if (typPozycji == 2) {
                            // Dodaj nową grę
                            boolean poprawnaNazwaGry = false;
                            String nazwaGry;
                            do {
                                System.out.print("Podaj nazwę gry: ");
                                nazwaGry = scanner.nextLine();
                                if (nazwaGry.equals("") || nazwaGry.length() > 120) {
                                    System.out.println("Błędna wartość dla nazwy gry!");
                                } else {
                                    poprawnaNazwaGry = true;
                                }
                            } while (!poprawnaNazwaGry);

                            int wiekMinimalny;
                            do {
                                System.out.print("Podaj minimalny wiek: ");
                                if (scanner.hasNextInt()) {
                                    wiekMinimalny = scanner.nextInt();
                                    if (wiekMinimalny <= 0 || wiekMinimalny > 150) {
                                        System.out.println("Błędna wartość dla minimalnego wieku!");
                                        scanner.nextLine(); // consume newline
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Błędna wartość dla minimalnego wieku!");
                                    scanner.next(); // consume invalid input
                                }
                            } while (true);
                            scanner.nextLine(); // consume newline after reading int

                            int wiekMaksymalny;
                            do {
                                System.out.print("Podaj maksymalny wiek: ");
                                if (scanner.hasNextInt()) {
                                    wiekMaksymalny = scanner.nextInt();
                                    if (wiekMaksymalny <= wiekMinimalny || wiekMaksymalny > 150) {
                                        System.out.println("Błędna wartość dla maksymalnego wieku!");
                                        scanner.nextLine(); // consume newline
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Błędna wartość dla maksymalnego wieku!");
                                    scanner.next(); // consume invalid input
                                }
                            } while (true);
                            scanner.nextLine(); // consume newline after reading int

                            boolean poprawneImie = false;
                            String imieKlienta;
                            do {
                                System.out.print("Podaj imię klienta: ");
                                imieKlienta = scanner.nextLine();
                                if (imieKlienta.equals("") || imieKlienta.length() > 50) {
                                    System.out.println("Błędna wartość dla imienia klienta!");
                                } else {
                                    poprawneImie = true;
                                }
                            } while (!poprawneImie);

                            boolean poprawneNazwisko = false;
                            String nazwiskoKlienta;
                            do {
                                System.out.print("Podaj nazwisko klienta: ");
                                nazwiskoKlienta = scanner.nextLine();
                                if (nazwiskoKlienta.equals("") || nazwiskoKlienta.length() > 50) {
                                    System.out.println("Błędna wartość dla nazwiska klienta!");
                                } else {
                                    poprawneNazwisko = true;
                                }
                            } while (!poprawneNazwisko);

                            int wiekKlienta;
                            do {
                                System.out.print("Podaj wiek klienta: ");
                                if (scanner.hasNextInt()) {
                                    wiekKlienta = scanner.nextInt();
                                    if (wiekKlienta <= 0 || wiekKlienta > 150) {
                                        System.out.println("Błędna wartość dla wieku klienta!");
                                        scanner.nextLine(); // consume newline
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Błędna wartość dla wieku klienta!");
                                    scanner.next(); // consume invalid input
                                }
                            } while (true);
                            scanner.nextLine(); // consume newline after reading int

                            // Tworzenie nowej gry i klienta
                            Gra gra = new Gra();
                            gra.setNazwa(nazwaGry);
                            gra.setWiekMinimalny(wiekMinimalny);
                            gra.setWiekMaksymalny(wiekMaksymalny);

                            Klient klient = new Klient();
                            klient.setImie(imieKlienta);
                            klient.setNazwisko(nazwiskoKlienta);
                            klient.setWiek(wiekKlienta);

                            gra.setKlient(klient);

                            if (klient.getWiek() < gra.getWiekMinimalny() || klient.getWiek() > gra.getWiekMaksymalny()) {
                                System.out.println("Masz nieodpowiedni wiek na wypozyczenie tej gry!");
                            } else {
                                bazaWypozyczen.getWypozyczenia().add(gra);
                            }

                        } else {
                            System.out.println("Błędna wartość!");
                        }
                        break;
                    case 2:
                        // Wyświetl listę wypożyczeń
                        System.out.println("Lista wypożyczeń");
                        int nrporzadkowy = 1;
                        for (Wypozyczenie x : bazaWypozyczen.getWypozyczenia()) {
                            if (x instanceof Ksiazka) {
                                Ksiazka k = (Ksiazka) x;
                                System.out.println(nrporzadkowy + " " + k.getNazwa() + " " + k.getAutor() + " ksiazka " + x.getKlient().getNazwisko() + " " + x.getKlient().getWiek());
                            } else if (x instanceof Gra) {
                                Gra g = (Gra) x;
                                System.out.println(nrporzadkowy + " " + g.getNazwa() + " gra " + x.getKlient().getNazwisko() + " " + x.getKlient().getWiek());
                            }
                            nrporzadkowy++;
                        }
                        break;
                    case 3:
                        // Generuj raport
                        raportGenerator.generujRaport(bazaWypozyczen);
                        break;
                    case 4:
                        // Zapisz do pliku
                        System.out.println("Podaj nazwę pliku do zapisu (np. lista_produktow.txt): ");
                        String nazwaPliku = scanner.nextLine();
                        try {
                            exporter.export(bazaWypozyczen.getWypozyczenia(), nazwaPliku);
                            System.out.println("Lista produktów została zapisana do pliku: " + nazwaPliku);
                        } catch (IOException e) {
                            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
                        }
                        break;
                    case 5:
                        // Opusc biuro podrozy
                        System.out.println("Do zobaczenia!");
                        wantExit = true;
                        break;
                    default:
                        System.out.println("Błędna wartość!");
                }
            } else {
                System.out.println("Błędna wartość!");
                scanner.next();
            }
        }
        scanner.close();
    }
}
