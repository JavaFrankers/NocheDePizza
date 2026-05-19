package org.javafrankers.helpers;

public class Guier {
    private final String HEADER =
            "========================================\n" +
            "    NOCHEDEPIZZA\n" +
            "========================================";
    private final String FOOTER =
            "----------------------------------------\n" +
                    "Elige una opción:";
    public void print(String entry) {
        System.out.println(HEADER + "\n" + entry + "\n" + FOOTER);
    }


}
