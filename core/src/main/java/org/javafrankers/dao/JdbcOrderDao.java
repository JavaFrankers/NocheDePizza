package org.javafrankers.dao;

import com.mysql.cj.xdevapi.Client;
import org.javafrankers.model.Order;

import javax.sql.DataSource;
import java.util.List;

public class JdbcOrderDao implements OrderDao{
    private final DataSource ds;

    public JdbcOrderDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Order createOrder(Client client){
        String sql = "INSERT INTO orders (id, cliente_id, fecha, total, estado) VALUES (?, ?, ?, ?, ?)";
        return new Order();
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public List<Order> listDailyOrders() {
        return List.of();
    }

    @Override
    public List<Order> showAllOrders(Client client) {
        return List.of();
    }
}
