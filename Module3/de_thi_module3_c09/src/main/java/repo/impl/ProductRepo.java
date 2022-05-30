package repo.impl;

import model.Category;
import model.Color;
import model.Product;
import repo.IProductRepo;
import repo.database_connection.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    BaseRepository baseRepository = new BaseRepository();
    ColorRepo colorRepo = new ColorRepo();
    CategoryRepo categoryRepo = new CategoryRepo();

    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM product;";
    private static final String INSERT_PRODUCT = "INSERT INTO product(product_name,price,quantity,color_id,category_id) values(?,?,?,?,?);";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE product_id =?;";
    private static final String SEARCH_PRODUCT_BY_NAME = "SELECT * FROM product WHERE product_name LIKE concat( \"%\",?,\"%\");";
//   private static final String SEARCH_PRODUCT_BY_PRICE = "SELECT * FROM product WHERE price LIKE concat(\"%\",?,\"%\");";
    private static final String SEARCH_PRODUCT_BY_PRICE = "SELECT * FROM product WHERE price = ?;";
    private static final String FIND_PRODUCT_BY_ID = "SELECT * FROM product WHERE product_id =?;";
    private static final String UPDATE_PRODUCT_BY_ID = "UPDATE product SET product_name=?,price=?,quantity=?,color_id=?,category_id=? WHERE product_id=?;";


    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");
                Color colorId = colorRepo.selectColorById(resultSet.getInt("color_id"));
                Category categoryId = categoryRepo.selectCategoryById(resultSet.getInt("category_id"));
                Product product = new Product(id, name, price, quantity, colorId, categoryId);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public void insertProduct(Product product) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setInt(4, product.getColorId().getColorId());
            preparedStatement.setInt(5, product.getCategoryId().getCategoryId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeProductById(Integer id) {
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Product findProductById(Integer productId) {
        Product product = null;
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("product_name");
                Double salary = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");

                Color colorId = colorRepo.selectColorById(resultSet.getInt("color_id"));
                Category categoryId = categoryRepo.selectCategoryById(resultSet.getInt("category_id"));

                product = new Product(productId,name,salary,quantity,colorId,categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection =null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setInt(4, product.getColorId().getColorId());
            preparedStatement.setInt(5, product.getCategoryId().getCategoryId());
            preparedStatement.setInt(6, product.getProductId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> searchProductByName(String searchWord) {
        List<Product> productList = new ArrayList<>();
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME);
            preparedStatement.setString(1, searchWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");
                Color color = colorRepo.selectColorById(resultSet.getInt("color_id"));
                Category category = categoryRepo.selectCategoryById(resultSet.getInt("category_id"));

                Product product = new Product(id, name, price, quantity, color, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public List<Product> searchProductByPrice(Double searchWord) {
        List<Product> productList = new ArrayList<>();
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_PRICE);
            preparedStatement.setDouble(1, searchWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");
                Color color = colorRepo.selectColorById(resultSet.getInt("color_id"));
                Category category = categoryRepo.selectCategoryById(resultSet.getInt("category_id"));

                Product product = new Product(id, name, price, quantity, color, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
