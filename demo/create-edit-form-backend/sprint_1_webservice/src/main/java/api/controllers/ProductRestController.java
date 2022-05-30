package api.controllers;

import api.models.Product;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/list")
    public ResponseEntity<Iterable<Product>> listProduct() {
        Iterable<Product> productList = this.iProductService.getAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = this.iProductService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (this.iProductService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteProduct() {
        return null;
    }
}
