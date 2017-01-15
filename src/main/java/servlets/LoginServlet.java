package servlets;

/**
 * Created by HackuunaMatata on 15.01.2017.
 */

import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.UsersDAO;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        MySQLDAO dao = DAOFactory.getInstanceMySQL();
        UsersDAO usersDAO = dao.getUsersDAO();
        try {
            if (login.equals("") && password.equals("")) throw new Error("Incorrect");
            int id = usersDAO.getIdByLogin(login);
            if (id == -1) throw new Error("Incorrect");

            Users user = usersDAO.getUserById(id);
            if (!user.getPassword().equals(password)) throw new Error("Incorrect");

            request.getSession().setAttribute("user", user);

            request.getRequestDispatcher("/jsp/registration.jsp").forward(request, response);
        } catch (Error e) {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
