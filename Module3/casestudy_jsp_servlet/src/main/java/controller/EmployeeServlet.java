package controller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import service.employee_service.IDivisionService;
import service.employee_service.IEducationDegreeService;
import service.employee_service.IEmployeeService;
import service.employee_service.IPositionService;
import service.employee_service.impl.DivisionService;
import service.employee_service.impl.EducationDegreeService;
import service.employee_service.impl.EmployeeService;
import service.employee_service.impl.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    IPositionService positionService = new PositionService();
    IEducationDegreeService educationDegreeService = new EducationDegreeService();
    IDivisionService divisionService = new DivisionService();

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
                deleteEmployee(request, response);
                break;


            case "sort":
//                    sortByName(request, response);
                break;
            default:
                employeeList(request, response);
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
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//
//        }
        }
}


    private void employeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAllEmployee();
        RequestDispatcher dispatcher;
        try {
            request.setAttribute("employeeList", employeeList);
            dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) {

        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("employeeName");
        String birthday = request.getParameter("employeeBirthday");
        String idCard = request.getParameter("employeeIdCard");
        Double salary = Double.valueOf(request.getParameter("employeeSalary"));
        String phone = request.getParameter("employeePhone");
        String email = request.getParameter("employeeEmail");
        String address = request.getParameter("employeeAddress");
        Position positionId = positionService.selectPositionById(Integer.parseInt(request.getParameter("positionName")));
        EducationDegree educationDegreeId = educationDegreeService.selectEducationDegreeById(Integer.parseInt(request.getParameter("educationDegreeName")));
        Division division = divisionService.selectDivisionById(Integer.parseInt(request.getParameter("divisionName")));
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, division);
        employeeService.insertEmployee(employee);
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer employeeId = Integer.valueOf(request.getParameter("id"));
            Employee existingEmployee = employeeService.findEmployeeById(employeeId);
            request.setAttribute("employee", existingEmployee);

            List<Position> positionList = positionService.selectAllPosition();
            List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
            List<Division> divisionList = divisionService.selectAllDivision();

            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("divisionList", divisionList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("employeeId"));
        String name = request.getParameter("employeeName");
        String birthday = request.getParameter("employeeBirthday");
        String idCard = request.getParameter("employeeIdCard");
        Double salary = Double.valueOf(request.getParameter("employeeSalary"));
        String phone = request.getParameter("employeePhone");
        String email = request.getParameter("employeeEmail");
        String address = request.getParameter("employeeAddress");
        Position positionId = positionService.selectPositionById(Integer.parseInt(request.getParameter("positionName")));
        EducationDegree educationDegreeId = educationDegreeService.selectEducationDegreeById(Integer.parseInt(request.getParameter("educationDegreeName")));
        Division division = divisionService.selectDivisionById(Integer.parseInt(request.getParameter("divisionName")));
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, division);
        employeeService.updateEmployee(employee);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("deleteByModal"));
        employeeService.removeEmployeeById(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String searchWord = request.getParameter("searchWord");
        List<Employee> employeeList = employeeService.searchEmployeeByName(searchWord);
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("employee/list.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
