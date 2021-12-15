package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone", 100, "good", "ak88"));
        productList.add(new Product(2, "bphone", 120, "good", "ak88"));
        productList.add(new Product(3, "cphone", 140, "good", "ak88"));
        productList.add(new Product(4, "dphone", 160, "good", "ak88"));
        productList.add(new Product(5, "ephone", 180, "good", "ak88"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                list.add(product);
            }
        }
        return list;
    }

    @Override
    public int findByIndex(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(findByIndex(id), product);
    }

    @Override
    public void remove(int id) {
        productList.remove(findByIndex(id));
    }
}
