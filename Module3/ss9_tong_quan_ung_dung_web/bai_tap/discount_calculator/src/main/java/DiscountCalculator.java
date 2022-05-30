import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCalculator", value = "/DiscountCalculator")
public class DiscountCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String description = request.getParameter("product-description");
    float price = Float.parseFloat(request.getParameter("price"));
    int discount = Integer.parseInt(request.getParameter("discount"));
    float discountedPrice = price-discount*price/100;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("product description: "+description);
        writer.println("product price: "+ price);
        writer.println("discount: "+ discount);
        writer.println("discounted price"+discountedPrice);




        writer.println("</html>");





    }
}
