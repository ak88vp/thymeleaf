package codegym.service;

import codegym.model.Customer;
import codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);
    int findByIndex(int id);

    void update(int id, Product product);

    void remove(int id);
}
