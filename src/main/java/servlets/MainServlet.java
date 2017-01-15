package servlets;

import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.UsersDAO;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
@WebServlet(name = "main", urlPatterns = "")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MySQLDAO dao = DAOFactory.getInstanceMySQL();

        UsersDAO usersDAO = dao.getUsersDAO();
        List<Users> list = usersDAO.getTable();

//        System.out.println(list);
//        System.out.println("MainServlet");

        request.setAttribute("usersList", list);
        request.setAttribute("title", "Hello, JSP");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
