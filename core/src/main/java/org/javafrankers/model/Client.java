package org.javafrankers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private String cliente_id;
    private String name;
    private int number;
    private String direction;
}
