import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
    private List<String> cart = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>Your Cart:</h3>");
        if (cart.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            for (String item : cart) {
                out.println("<p>" + item + "</p>");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String product = request.getParameter("product");
        cart.add(product);
        response.sendRedirect("products.html");
    }
}
