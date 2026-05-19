package org.javafrankers.dao;

import org.javafrankers.model.Product;

import java.util.List;

public interface ProductDao {
    Product product();
    void update(Product product);
    List<Product> listProduct();
    void delete(Product product);
    void searchById(Product product);
}
