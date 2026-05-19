package org.javafrankers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private double price;
    //"PIZZA", "BEBIDA", "POSTRE"
    private String type;
}
