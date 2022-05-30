package service.impl;

import model.Product;
import repo.IProductRepo;
import repo.impl.ProductRepo;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepo productRepo = new ProductRepo();


    @Override
    public List<Product> findAllProduct() {
        return productRepo.findAllProduct();
    }

    @Override
    public void insertProduct(Product product) {
        productRepo.insertProduct(product);
    }

    @Override
    public void removeProductById(Integer id) {
        productRepo.removeProductById(id);
    }

    @Override
    public List<Product> searchProductByName(String searchWord) {
        return productRepo.searchProductByName(searchWord);
    }

    @Override
    public Product findProductById(Integer productId) {
        return productRepo.findProductById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    @Override
    public List<Product> searchProductByPrice(Double searchWord) {
        return productRepo.searchProductByPrice(searchWord);
    }
}
