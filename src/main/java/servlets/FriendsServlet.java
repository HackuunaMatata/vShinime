package servlets;

import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.UserInfoDAO;
import entities.UserInfo;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HackuunaMatata on 15.01.2017.
 */
@WebServlet(name = "Friends", urlPatterns = "/friends")
public class FriendsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        MySQLDAO dao = DAOFactory.getInstanceMySQL();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();
        UserInfo userInfo = userInfoDAO.getUserInfoById(id);

        List<UserInfo> friends = new ArrayList<>();

        switch (userInfo.getPositionId()) {
            case 1:
                friends = userInfoDAO.getForHead(userInfo.getMagazine());
                break;
            case 2:
                friends = userInfoDAO.getForOwner();
                break;
            case 3:
                friends = userInfoDAO.getForJournalist(userInfo.getMagazine());
                break;
            case 4:
                friends = userInfoDAO.getForHead(userInfo.getMagazine());
                break;
            case 5:
                friends = userInfoDAO.getForJournalist(userInfo.getMagazine());
                combine(friends, userInfoDAO.getForHead(userInfo.getMagazine()));
                break;
            default:
                break;
        }

        request.setAttribute("friends", friends);
        request.getRequestDispatcher("/jsp/friends.jsp").forward(request, response);

    }


    private static void combine(List<UserInfo> a, List<UserInfo> b) {
        boolean flag;
        for (UserInfo user2 : b) {
            flag = false;
            for (UserInfo user : a) {
                if (user2.equals(user)) flag = true;
            }
            if (!flag) a.add(user2);
        }

    }
}
