package org.javafrankers.dao;

import lombok.extern.slf4j.Slf4j;
import org.javafrankers.DataBaseConnection;
import org.javafrankers.model.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class JdbcProductDao implements ProductDao {
    private final DataSource ds;
    private Scanner scanner;
    public JdbcProductDao(DataSource ds) {this.ds = ds;}

    @Override
    public void create() {
        String sql = "insert into producto (nombre, precio, tipo) values(?,?,?);";
        try(Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            log.info("Nombre del producto");
            String name = scanner.nextLine();
            log.info("Precio del producto");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            log.info("Tipo de producto: 1.PIZZA, 2.BEBIDA o 3.POSTRE");
            log.info("Introduzca el numero");
            int opt;
            String tipe = "";
            opt = scanner.nextInt();
            if (opt == 1){
                 tipe = "PIZZA";
            } else if (opt == 2) {
                 tipe = "BEBIDA";
            } else if (opt == 3){
                 tipe = "POSTRE";
            } else {
                log.warn("Del 1 al 3");
            }
            scanner.nextLine();
            pstmt.setString(1,name);
            pstmt.setDouble(2,precio);
            pstmt.setString(3, tipe);
            int rows = pstmt.executeUpdate();
            System.out.println("Inserted " + rows + " row(s)");
        }catch (Exception e){
            log.error("a");
        }
    }

    @Override
    public void update() {
        String sql = "update producto set nombre = ?,precio = ?, tipo = ? where id = ?;";
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            log.info("Id del producto a actualizar");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (productExistsById(id)) {
                log.info("Nombre del producto");
                String name = scanner.nextLine();
                log.info("Precio del producto");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                log.info("Tipo de producto: 1.PIZZA, 2.BEBIDA o 3.POSTRE");
                log.info("Introduzca el numero");
                int opt;
                String tipe = "";
                opt = scanner.nextInt();
                if (opt == 1) {
                    tipe = "PIZZA";
                } else if (opt == 2) {
                    tipe = "BEBIDA";
                } else if (opt == 3) {
                    tipe = "POSTRE";
                } else {
                    log.warn("Del 1 al 3");
                }
                scanner.nextLine();
                pstmt.setString(1, name);
                pstmt.setDouble(2, precio);
                pstmt.setString(3, tipe);
                pstmt.setInt(4, id);
                int rows = pstmt.executeUpdate();
                System.out.println("Inserted " + rows + " row(s)");
            } else{
                log.error("El producto no existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @Override
//    public void update() {
//        String sql = "UPDATE producto SET nombre = ?, precio = ?, tipo = ? WHERE id = ?";
//        try (Connection conn = DataBaseConnection.getConnection()) {
//            log.info("Id del producto a actualizar");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//
//            if (!productExistsById(id)) {
//                log.error("El producto no existe");
//                return;
//            }
//
//            log.info("Nombre del producto");
//            String name = scanner.nextLine();
//            log.info("Precio del producto");
//            double precio = scanner.nextDouble();
//            scanner.nextLine();
//            log.info("Tipo de producto: 1.PIZZA, 2.BEBIDA o 3.POSTRE");
//            int opt = scanner.nextInt();
//            scanner.nextLine();
//
//            String tipe = switch (opt) {
//                case 1 -> "PIZZA";
//                case 2 -> "BEBIDA";
//                case 3 -> "POSTRE";
//                default -> {
//                    log.warn("Opción inválida, debe ser del 1 al 3");
//                    yield null;
//                }
//            };
//
//            if (tipe == null) return;
//
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, name);
//            pstmt.setDouble(2, precio);
//            pstmt.setString(3, tipe);
//            pstmt.setInt(4, id);
//            int rows = pstmt.executeUpdate();
//            log.info("Updated " + rows + " row(s)");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    @Override
    public void showProducts() {
        try (Connection conn = DataBaseConnection.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from producto");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                Double price = rs.getDouble("precio");
                String tipe = rs.getString("tipo");
                log.info(id+" "+name+" "+price+" "+tipe);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection()) {
            log.info("Introduzca la id del producto que desea eliminar");
            int id = scanner.nextInt();
            scanner.nextLine();
            log.warn("Esta seguro? s/n");
            String seguro = scanner.nextLine().trim();

            if (!seguro.equalsIgnoreCase("s")) {
                log.info("Operación cancelada");
                return;
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            log.info("Deleted " + rows + " row(s)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchById() {
        try (Connection conn = DataBaseConnection.getConnection()) {
            log.info("Introduzca la id del producto que desea consultar");
            int id = scanner.nextInt();
            scanner.nextLine();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM producto WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int productId = rs.getInt("id");
                String name = rs.getString("nombre");
                Double price = rs.getDouble("precio");
                String type = rs.getString("tipo");
                log.info(productId + " " + name + " " + price + " " + type);
            } else {
                log.info("No se encontró ningún producto con id: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean productExistsById(int id){
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM producto WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int productId = rs.getInt("id");
                String name = rs.getString("nombre");
                Double price = rs.getDouble("precio");
                String type = rs.getString("tipo");
                if( id == productId){
                    return true;
                }
            } else {
                log.info("No se encontró ningún producto con id: " + id);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
