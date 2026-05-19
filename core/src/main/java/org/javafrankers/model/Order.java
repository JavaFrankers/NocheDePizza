package org.javafrankers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private String idPedido;
    private String cliente_id;
    private LocalDate fecha;
    private double total;
    //state tiene 3 estados = PENDIENTE, ENTREGADO y CANCELADO
    private String state;
    private List<OrderLine> orderLines;

}
