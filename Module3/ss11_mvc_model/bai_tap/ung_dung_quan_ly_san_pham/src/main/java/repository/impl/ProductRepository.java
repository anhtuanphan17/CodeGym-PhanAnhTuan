package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Macbook", 500.0, "Chip M1", "Apple"));
        productMap.put(2, new Product(2, "Ipad", 400.0, "Chip A11", "Apple"));
        productMap.put(3, new Product(3, "Tivi", 800.0, "Smart Tivi", "Samsung"));
        productMap.put(4, new Product(4, "Refrigerator", 600.0, "G1 engine", "Sony"));
        productMap.put(5, new Product(5, "Earphone", 200.0, "HKL sound", "Bose"));

    }

    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>(productMap.values());
        return productList;
    }


    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
         productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }


}
