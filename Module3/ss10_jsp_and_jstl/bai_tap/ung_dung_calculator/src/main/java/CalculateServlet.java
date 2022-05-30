import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "CalculateServlet", value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    float firstNumber = Float.parseFloat(request.getParameter("first-operand"));
    float secondNumber = Float.parseFloat(request.getParameter("second-operand"));
    char operator = request.getParameter("operator").charAt(0);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        writer.println("<h1>Result: </h1>");


        try {
            float result = Calculator.calculate(firstNumber,secondNumber,operator);
            writer.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
        }catch (Exception e){
            writer.println("Invalid input");
        }

        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
