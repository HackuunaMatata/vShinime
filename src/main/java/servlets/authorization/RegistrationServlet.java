package servlets.authorization;

import DAO.DAOFactory;
import DAO.UserInfoDAO;
import DAO.UsersDAO;
import utils.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by HackuunaMatata on 15.01.2017.
 */

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DAOFactory dao = DAOFactory.getInstanceDAO();
        UsersDAO usersDAO = dao.getUsersDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();

        try {
            if(name.equals("") || surname.equals("") || email.equals("") || login.equals("") || password.equals(""))
                throw new Error("Incorrect");
            if (usersDAO.getIdByLogin(login) != -1) throw new Error("Login already exist");

            password = HashPassword.getMD5Hash(password);

            int id = usersDAO.addUser(login, password, email);
            userInfoDAO.addUserInfo(id, name, surname, -1, new Date(System.currentTimeMillis()), null, null);
            response.sendRedirect("/");
        } catch (Error e) {
            request.setAttribute("textError", e.getMessage());
            request.getRequestDispatcher("/jsp/registration.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("textError", "");
        request.getRequestDispatcher("/jsp/registration.jsp").forward(request, response);
    }
}

