package api.services.impl;

import api.models.Product;
import api.repositories.IProductRepository;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void saveProduct(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Product> getAllProduct() {
        return this.iProductRepository.findAll();
    }
}
