package controller;

import model.Sach;
import model.TheMuonSach;
import service.ISachService;
import service.ITheMuonSachService;
import service.impl.SachService;
import service.impl.TheMuonSachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/sach")
public class Servlet extends HttpServlet {
    ITheMuonSachService theMuonSachService = new TheMuonSachService();
    ISachService sachService = new SachService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
//                showCreateForm(request, response);
                break;
            case "muon":
                showMuonForm(request, response);
                break;
            case "delete":
//                deleteEmployee(request, response);
                break;


            case "sort":
//                    sortByName(request, response);
                break;
            default:
                showDanhSachSach(request, response);
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
//                createEmployee(request, response);
                break;
            case "edit":
//                editEmployee(request, response);
                break;
            case "search":
//                searchByName(request, response);
                break;
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//
//        }
        }

    }


    private void showDanhSachSach(HttpServletRequest request, HttpServletResponse response) {
        List<Sach> sachList = sachService.findAllSach();
        RequestDispatcher dispatcher;
        try {
            request.setAttribute("sachList", sachList);
            dispatcher = request.getRequestDispatcher("sach/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void showMuonForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer sachId = Integer.valueOf(request.getParameter("id"));
            Sach existingSach = sachService.findSachById(sachId);

            request.setAttribute("sach", existingSach);

//            List<Color> colorList = colorService.selectAllColor();
//            List<Category> categoryList = categoryService.selectAllCategory();
//            request.setAttribute("colorList",colorList);
//            request.setAttribute("categoryList",categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/sach/muon.jsp");

            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

//    private void showTheMuonSachList(HttpServletRequest request, HttpServletResponse response) {
//                List<TheMuonSach> theMuonSachList = theMuonSachService.findAllTheMuonSach();
//        RequestDispatcher dispatcher;
//        try {
//            request.setAttribute("employeeList", employeeList);
//            dispatcher = request.getRequestDispatcher("employee/list.jsp");
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }

//    private void employeeList(HttpServletRequest request, HttpServletResponse response) {
//        List<Employee> employeeList = mainService.findAll();
//        RequestDispatcher dispatcher;
//        try {
//            request.setAttribute("employeeList", employeeList);
//            dispatcher = request.getRequestDispatcher("employee/list.jsp");
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


//    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//
//        List<Position> positionList = positionService.selectAllPosition();
//        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
//        List<Division> divisionList = divisionService.selectAllDivision();
//
//        request.setAttribute("positionList", positionList);
//        request.setAttribute("educationDegreeList", educationDegreeList);
//        request.setAttribute("divisionList", divisionList);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    chức năng xóa


//    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
//        Integer id = Integer.valueOf(request.getParameter("deleteByModal"));
//        employeeService.removeEmployeeById(id);
//        try {
//            response.sendRedirect("/employee");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
