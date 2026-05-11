package org.javafrankers.dao;

import com.mysql.cj.xdevapi.Client;
import org.javafrankers.model.Order;
import org.javafrankers.model.OrderLine;

import java.util.List;

public interface OrderDao {
    Order createOrder(Client client);
    void update(Order order);
    List<Order> listDailyOrders();
    List<Order> showAllOrders(Client client);
}
