package servlets;

/**
 * Created by HackuunaMatata on 15.01.2017.
 */

import DAO.DAOFactory;
import DAO.MessagesDAO;
import DAO.MySQL.MySQLDAO;
import DAO.UsersDAO;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        MessagesDAO messagesDAO = dao.getMessagesDAO();

        try {
            if (login.equals("") || password.equals("")) throw new Error("Incorrect");
            int id = usersDAO.getIdByLogin(login);
            if (id == -1) throw new Error("Incorrect login or password");

            Users user = usersDAO.getUserById(id);
            if (!user.getPassword().equals(password)) throw new Error("Incorrect login or password");

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("messages", messagesDAO.countAllUnreadMessages(id));

            response.sendRedirect("/profile");
        } catch (Error e) {
            request.setAttribute("loginError", e.getMessage());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
