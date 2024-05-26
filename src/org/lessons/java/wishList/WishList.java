package org.lessons.java.wishList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) throws IOException {
        List<Present> wishList = new ArrayList<>(); // inizializzo la lista
        File list = new File("./resources/wishList.txt");   // salvo il path del file
        Scanner scanner = new Scanner(System.in);   // inizializzo lo scanner
        Scanner listReader = new Scanner(list); // inizializzo lo scanner per leggere il file
        int choice = -1;
        readListFromFile(listReader, wishList); // leggo dal file e salvo nella lista
        listReader.close(); // chiudo lo scanner per leggere da file


        while (choice != 0) {
            printMenu();
            System.out.print("Inserisci il numero corrispondente: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // put new present in wishList
                    System.out.print("Inserisci nome del nuovo regalo: ");
                    wishList.add(new Present(scanner.nextLine()));  // aggiungo il nuovo regalo alla lista
                    break;
                case 2:
                    // print wishList
                    printList(wishList);    // stampo la lista dei regali
                    break;
                case 3:
                    // save wishList
                    try {
                        writeListToFile(list, wishList);  // scrivo la lista sul file
                    } catch (IOException luisa) {
                        System.out.println("Unable to save the wish list");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
        scanner.close();
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println("|       MENU       |");
        System.out.println("--------------------");
        System.out.println("1 - Inserisci nuovo regalo");
        System.out.println("2 - Stampa lista regali");
        System.out.println("3 - Salva lista");
        System.out.println("0 - Esci");
    }

    public static void printList(List<Present> list) {
        int counter = 1;
        for (Present present : list) {
            System.out.println("Present n." + counter + " " + present.getName());
            counter++;
        }
    }

    public static void writeListToFile(File f, List<Present> list) throws IOException {
        int counter = 1;
        FileWriter writer = new FileWriter(f);   // inizializzo il file writer
//        if (list.isEmpty()) {
//            counter = 1;
//        } else {
//            counter = list.size();
//        }
        for (Present present : list) {
            writer.write("Present n." + counter + " " + present.getName());
            writer.write("\n");
            counter++;
        }
        writer.close(); // chiudo il file writer
    }

    public static void readListFromFile(Scanner fr, List<Present> list) {
        while (fr.hasNextLine()) {
//            System.out.println(fr.nextLine().substring(12));
            list.add(new Present(fr.nextLine().substring(12)));
        }
//        fr.close();
    }
}
