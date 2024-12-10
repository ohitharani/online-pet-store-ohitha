import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserServlet extends HttpServlet {
    private Map<String, String> userDatabase = new HashMap<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (userDatabase.containsKey(username)) {
                out.println("<h3>Username already exists. Try again!</h3>");
            } else {
                userDatabase.put(username, password);
                out.println("<h3>Registration successful! Please <a href='index.html'>login</a>.</h3>");
            }
        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                response.sendRedirect("products.html");
            } else {
                out.println("<h3>Invalid login. Please try again!</h3>");
            }
        }
    }
}
