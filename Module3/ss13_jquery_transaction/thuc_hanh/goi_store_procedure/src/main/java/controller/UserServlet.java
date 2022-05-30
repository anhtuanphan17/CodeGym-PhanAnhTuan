package controller;

import model.User;
import repository.impl.UserRepository;
import service.IUserService;
import service.impl.UserService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.UserServlet", value = {"/users",""})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserRepository userRepository;

    IUserService iUserService = new UserService();

    public void init() {
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sort":
                    sortByName(request, response);
                    break;
                case "permision":
                    addUserPermission(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
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
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "search":
                    searchById(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }


    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> listUser = iUserService.getUserList();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);


    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = iUserService.selectUser(id);
        User existingUser = iUserService.getUserById(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");

        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        iUserService.insertUser(newUser);
//        iUserService.insertUserStore(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User book = new User(id, name, email, country);
        iUserService.edit_user(book);
//           RequestDispatcher dispatcher = request.getRequestDispatcher("/users");
//           dispatcher.forward(request, response);
        response.sendRedirect("/users");

    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
//        iUserService.deleteUser(id);
            iUserService.deleteUserById(id);
        List<User> listUser = iUserService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String search = request.getParameter("search");
        List<User> userList = iUserService.searchByCountry(search);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        dispatcher.forward(request, response);

    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permisions = {1, 2, 4};

        iUserService.addUserTransaction(user, permisions);

    }


    private void sortByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<User> userList = iUserService.sortByName();
        request.setAttribute("listUser", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        iUserService.insertUpdateWithoutTransaction();

    }

}

