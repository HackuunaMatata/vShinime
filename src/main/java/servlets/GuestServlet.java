package servlets;

import DAO.*;
import DAO.MySQL.MySQLDAO;
import entities.Articles;
import entities.UserInfo;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HackuunaMatata on 16.01.2017.
 */
@WebServlet(name = "Guest", urlPatterns = "/guest")
public class GuestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        DAOFactory dao = DAOFactory.getInstanceDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();
        UsersDAO usersDAO = dao.getUsersDAO();
        PositionsDAO positionsDAO = dao.getPositionsDAO();
        ArticlesDAO articlesDAO = dao.getArticlesDAO();

        Users user = usersDAO.getUserById(id);
        UserInfo userInfo = userInfoDAO.getUserInfoById(id);
        String position = positionsDAO.getPositionById(userInfo.getPositionId()).getName();
        List<Articles> articles = articlesDAO.getArticlesByUserId(id);

        request.setAttribute("friend", user);
        request.setAttribute("userInfo", userInfo);
        request.setAttribute("position", position);
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/jsp/guest.jsp").forward(request, response);
    }
}
