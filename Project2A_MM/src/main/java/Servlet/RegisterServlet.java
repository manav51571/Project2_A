package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
   
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company = HashUtil.hash(req.getParameter("company"));
        String firstName = HashUtil.hash(req.getParameter("firstname"));
        String lastName = HashUtil.hash(req.getParameter("lastname"));
        String email = HashUtil.hash(req.getParameter("email"));
        String sector = HashUtil.hash(req.getParameter("sector"));
        String dietary = HashUtil.hash(req.getParameter("dietary"));
        boolean parking = req.getParameter("parking") != null;
        //System.out.println(company);
        //System.out.println(firstName);
        //System.out.println(lastName);
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2", "Project2MM", "pass123");
            String sql = "INSERT INTO Conference_Registration (Company, FirstName, LastName, Email, Sector, DietaryRequirements, ParkingRequired) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, company);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, sector);
            ps.setString(6, dietary);
            ps.setBoolean(7, parking);
            ps.executeUpdate();
            ps.close();
            conn.close();
            resp.getWriter().println("Registration Successful!");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
