package org.lessons.java.wishList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {
        List<Present> wishList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

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
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida");
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
        System.out.println("0 - Esci");
    }

    public static void printList(List<Present> list) {
        int counter = 1;
        for (Present present : list) {
            System.out.println("Present n." + counter + " " + present.getName());
            counter++;
        }
    }
}
