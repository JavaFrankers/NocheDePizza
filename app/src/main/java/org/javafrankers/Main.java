package org.javafrankers;

import org.javafrankers.app.NochedepizzaApp;
import org.javafrankers.dao.JdbcProductDao;
import org.javafrankers.dao.ProductDao;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JdbcProductDao dbProduct = new JdbcProductDao(ProductDao);
        NochedepizzaApp app = new NochedepizzaApp(scanner, dbProduct);

        app.run();
    }
}