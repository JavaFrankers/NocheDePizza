package org.javafrankers.readers;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.javafrankers.model.Product;

import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class ReaderProduct {
    private final Scanner scanner;

    public Product read(){

        log.info("Necesito el ID del producto compañero");
        String id = scanner.nextLine();

        log.info("Pues ahora dame el nombre del producto");
        String name = scanner.nextLine();

        log.info("Bien... ahora dame su precio");
        double price = scanner.nextDouble();
        scanner.nextLine();

        log.info("Maravilloso, para finalizar dame el tipo del producto");
        String type = scanner.nextLine();

        return new Product(id, name, price, type);
    }
}
