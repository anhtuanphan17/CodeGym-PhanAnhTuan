package controller;

import model.Category;
import model.Color;
import model.Product;
import service.ICategoryService;
import service.IColorService;
import service.IProductService;
import service.impl.CategoryService;
import service.impl.ColorService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    IColorService colorService = new ColorService();
    ICategoryService categoryService = new CategoryService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "sort":
//                    sortByName(request, response);
                break;
            default:
                productList(request, response);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
        switch (action) {
            case "create":
                    createProduct(request, response);
                break;
            case "edit":
                    editProduct(request, response);
                break;
            case "searchName":
                    searchByName(request, response);
                break;
            case "searchPrice":
                searchByPrice(request, response);
                break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
        }
    }




    private void productList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.findAllProduct();
        try {
            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Color> colorList = colorService.selectAllColor();
        List<Category> categoryList = categoryService.selectAllCategory();
        request.setAttribute("colorList",colorList);
        request.setAttribute("categoryList",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        Color color = colorService.selectColorById(Integer.parseInt(request.getParameter("color")));
        Category category = categoryService.selectCategoryById(Integer.parseInt(request.getParameter("category")));

        Product product = new Product(name,price,quantity,color,category);
        productService.insertProduct(product);


        List<Color> colorList = colorService.selectAllColor();
        List<Category> categoryList = categoryService.selectAllCategory();
        request.setAttribute("colorList",colorList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("deleteByModal"));
        productService.removeProductById(id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String searchWord = request.getParameter("searchWord");
        List<Product> productList = productService.searchProductByName(searchWord);
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("product/list.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer productId = Integer.valueOf(request.getParameter("id"));
            Product existingProduct = productService.findProductById(productId);
            request.setAttribute("product", existingProduct);

            List<Color> colorList = colorService.selectAllColor();
            List<Category> categoryList = categoryService.selectAllCategory();
            request.setAttribute("colorList",colorList);
            request.setAttribute("categoryList",categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");

            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("productId"));
        String name = request.getParameter("productName");
        Double price = Double.valueOf(request.getParameter("price"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        Color color = colorService.selectColorById(Integer.parseInt(request.getParameter("color")));
        Category category = categoryService.selectCategoryById(Integer.parseInt(request.getParameter("category")));

        Product product = new Product(id,name,price,quantity,color,category);
        productService.updateProduct(product);

        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void searchByPrice(HttpServletRequest request, HttpServletResponse response) {
        Double searchWord = Double.valueOf(request.getParameter("searchWord"));
        List<Product> productList = productService.searchProductByPrice(searchWord);
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("product/list.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
