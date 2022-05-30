package api.services;

import api.models.Product;

public interface IProductService {
    void saveProduct(Product product);

    Product findById(Long id);

    Iterable<Product> getAllProduct();
}
