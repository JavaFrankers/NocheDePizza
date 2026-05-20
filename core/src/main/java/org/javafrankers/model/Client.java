package org.javafrankers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private String id;
    private String name;
    private int number;
    private String direction;
}
