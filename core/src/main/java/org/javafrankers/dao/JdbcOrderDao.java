package org.javafrankers.dao;

import com.mysql.cj.xdevapi.Client;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.javafrankers.DataBaseConnection;
import org.javafrankers.model.Cliente;
import org.javafrankers.model.Order;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Log4j
public class JdbcOrderDao implements OrderDao{
    private final DataSource ds;
    public JdbcOrderDao(DataSource ds) {
        this.ds = ds;
    }

//    @Override
//    public Order createOrder(Cliente client){
//        String sql = "INSERT INTO pedido (id, id_cliente, fecha, total, cantidad) VALUES (?, ?, ?, ?, ?)";
//        String sql2 = "INSERT INTO lineaPedido(id,id_pedido,id_producto,cantidad values (?,?,?,)";
//        try (Connection conn = DataBaseConnection.getConnection()){
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new Order(idPedido,cliente_id,fecha,total,estado,productos);
//    }

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

    @Override
    public Order findOrderByID(int id) {
        return null;
    }

    @Override
    public void createOrder(Client client) {

    }
}
