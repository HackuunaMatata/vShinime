package servlets;

import DAO.ArticlesDAO;
import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.PositionsDAO;
import DAO.UserInfoDAO;
import entities.Articles;
import entities.UserInfo;
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
 * Created by HackuunaMatata on 15.01.2017.
 */

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();
        UserInfo userInfo = userInfoDAO.getUserInfoById(id);

        String position;
        if (userInfo.getPositionId() == -1) {
            position = "Unknown";
        } else {
            PositionsDAO positionsDAO = dao.getPositionsDAO();
            position = positionsDAO.getPositionById(userInfo.getPositionId()).getName();
        }
        if (userInfo.getMagazine().equals("null")) {
            userInfo.setMagazine("Unknown");
        }

        ArticlesDAO articlesDAO = dao.getArticlesDAO();
        List<Articles> articlesByUserId = articlesDAO.getArticlesByUserId(id);

        System.out.println(userInfo);

        request.setAttribute("userInfo", userInfo);
        request.setAttribute("position", position);
        request.setAttribute("articles", articlesByUserId);
        request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }

}
