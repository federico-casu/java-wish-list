package org.lessons.java.charCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        Map<Character, Integer> characters = new HashMap<>();
        String word;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una parola: ");
        word = scanner.nextLine();

        for (int i = 0; i < word.length(); i++) {
            if (!characters.containsKey(word.charAt(i))) {
                characters.put(word.charAt(i), 1);
            } else {
                characters.replace(word.charAt(i), characters.getOrDefault(word.charAt(i), 1), characters.getOrDefault(word.charAt(i), 1)+1);
            }
        }

        Iterator<Character> itr = characters.keySet().iterator();
        while (itr.hasNext()) {
            Character key = itr.next();
            Integer value = characters.get(key);
            System.out.printf("%c: %d%n", key, value);
        }

        scanner.close();

    }
}
