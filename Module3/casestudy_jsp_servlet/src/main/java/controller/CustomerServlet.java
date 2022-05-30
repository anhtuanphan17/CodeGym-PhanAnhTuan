package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.Employee;
import service.customer_service.ICustomerService;
import service.customer_service.ICustomerTypeService;
import service.customer_service.impl.CustomerService;
import service.customer_service.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")

public class CustomerServlet extends HttpServlet {

    ICustomerService customerService = new CustomerService();
    ICustomerTypeService customerTypeService = new CustomerTypeService();

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
                deleteCustomer(request, response);
                break;
            case "sort":
//                    sortByName(request, response);
                break;
            default:
                customerList(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    editCustomer(request, response);
                    break;
                case "search":
                    searchByName(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }


    public void customerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAllCustomers();
        try {
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        Integer customerGender = Integer.valueOf(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        CustomerType customerTypeId = customerTypeService.selectCustomerType(Integer.parseInt(request.getParameter("customerTypeId")));

        Customer customer = new Customer(customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId);
        customerService.insertCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer customerId = Integer.valueOf(request.getParameter("id"));
            Customer existingCustomer = customerService.findCustomerById(customerId);
            request.setAttribute("customer", existingCustomer);
            List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
            request.setAttribute("customerTypeList", customerTypeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        Integer customerGender = Integer.valueOf(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        CustomerType customerTypeId = customerTypeService.selectCustomerType(Integer.parseInt(request.getParameter("customerTypeName")));
        Customer customer = new Customer(id, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId);
        customerService.updateCustomer(customer);
//        RequestDispatcher dispatcher =request.getRequestDispatcher("/customer/edit.jsp");
        try {
            response.sendRedirect("/customer/edit.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            customerService.removeCustomerById(id);
            List<Customer> customerList = customerService.findAllCustomers();
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            dispatcher.forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String searchWord = request.getParameter("searchWord");
        List<Customer> customerList = customerService.searchCustomerByName(searchWord);
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("customer/list.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

