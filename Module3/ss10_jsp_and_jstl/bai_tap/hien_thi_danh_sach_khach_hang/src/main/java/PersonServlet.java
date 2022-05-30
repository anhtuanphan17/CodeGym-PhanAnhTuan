import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Ronaldo", "1983-08-20", "Ha Noi", "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg"));
        personList.add(new Person("Benzema", "1988-09-20", "HCM", "https://i1-thethao.vnecdn.net/2021/10/19/Untitled-3553-1634580285.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=sgoldHAP67dEwLz5dlPA4Q"));
        personList.add(new Person("Ozil", "1993-01-23", "Da Nang", "https://image.thanhnien.vn/w2048/Uploaded/2022/cjhwpdhnw/2022_01_10/ozil-reuters-3865.jpeg"));
        personList.add(new Person("Neuer", "1992-07-05", "Tokyo", "https://static.dw.com/image/52628815_303.jpg"));



        request.setAttribute("list1", personList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }









    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
