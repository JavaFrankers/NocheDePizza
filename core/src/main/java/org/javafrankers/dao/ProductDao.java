package org.javafrankers.dao;

import org.javafrankers.model.Product;

import java.util.List;

public interface ProductDao {
    void create();
    void update();
    void showProducts();
    void delete();
    void searchById();
}
