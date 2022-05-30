package ss17_binary_file_and_serialization.bai_tap.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String productCode;
    private String name;
    private String producer;
    private double price;
    private String otherDescription;


    public Product(String productCode, String name, String producer, double price, String otherDescription) {
        this.productCode = productCode;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.otherDescription = otherDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }
}

