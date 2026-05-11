package org.javafrankers.model;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private String idPedido;
    private String cliente_id;
    private LocalDate fecha;
    private double total;
    private boolean state;
    private List<OrderLine> orderLines;

}
