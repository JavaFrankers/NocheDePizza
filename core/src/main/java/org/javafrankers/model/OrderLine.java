package org.javafrankers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLine {
    private String idOrderLine;
    private String id_order;
    private String id_product;
    private String cantidad;

}
