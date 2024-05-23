package org.lessons.java.wishList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) throws IOException {
        List<Present> wishList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        FileWriter writer = new FileWriter("./resources/wishList.txt", true);

        while (choice != 0) {
            printMenu();
            System.out.print("Inserisci il numero corrispondente: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // put new present in wishList
                    System.out.print("Inserisci nome del nuovo regalo: ");
                    wishList.add(new Present(scanner.nextLine()));
                    break;
                case 2:
                    // print wishList
                    printList(wishList);
                    break;
                case 3:
                    // save wishList
                    try {
                        writeListToFile(writer, wishList);
                    } catch (IOException luisa) {
                        System.out.println("Unable to save the wish list");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
        writer.close();
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

    public static void writeListToFile(FileWriter fw, List<Present> list) throws IOException {
        int counter = 1;
        for (Present present : list) {
            fw.write("\nPresent n." + counter + " " + present.getName());
            counter++;
        }
    }
}
