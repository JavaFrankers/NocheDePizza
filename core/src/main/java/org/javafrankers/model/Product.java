package org.javafrankers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private int price;
    private String type;
}
