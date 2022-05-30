package model;

public class Product {
    private Integer productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Color colorId;
    private Category categoryId;

    public Product(Integer productId, String productName, Double price, Integer quantity, Color colorId, Category categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.colorId = colorId;
        this.categoryId = categoryId;
    }

    public Product(String productName, Double price, Integer quantity, Color colorId, Category categoryId) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.colorId = colorId;
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
