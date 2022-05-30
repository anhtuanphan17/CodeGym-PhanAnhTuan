package ss12_java_collection_framework.bai_tap.arraylist_linkedlist_in_java_collections.model;

public class Product implements Comparable<Product> {
    private String productName;
    private String id;
    private double price;

    public Product() {
    }

    public Product(String productName, String id, double price) {
        this.productName = productName;
        this.id = id;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {

        return (int) (this.getPrice() - o.getPrice());
    }
}