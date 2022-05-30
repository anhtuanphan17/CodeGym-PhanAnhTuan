package service;

import model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAllProduct();

    void insertProduct(Product product);

    void removeProductById(Integer id);

    List<Product> searchProductByName(String searchWord);

    Product findProductById(Integer productId);

    void updateProduct(Product product);

    List<Product> searchProductByPrice(Double searchWord);
}
