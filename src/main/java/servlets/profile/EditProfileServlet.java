package servlets.profile;

import DAO.DAOFactory;
import DAO.PositionsDAO;
import DAO.UserInfoDAO;
import DAO.UsersDAO;
import entities.Positions;
import entities.UserInfo;
import entities.Users;
import org.apache.log4j.Logger;
import utils.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by HackuunaMatata on 16.01.2017.
 */
@WebServlet(name = "EditProfile", urlPatterns = "/editProfile")
@MultipartConfig
public class EditProfileServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(EditProfileServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();
        UsersDAO usersDAO = dao.getUsersDAO();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Date bday = getDateFromString(request.getParameter("bday"));
        String magazine = request.getParameter("magazine");
        int position = Integer.parseInt(request.getParameter("position"));

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (password.equals("")) password = user.getPassword();
        else password = HashPassword.getMD5Hash(password);

        userInfoDAO.updateUserInfo(name, surname, bday, position, magazine, id);
        usersDAO.updateUser(password, email, id);

        session.setAttribute("user", new Users(id, user.getLogin(), password, email));

        response.sendRedirect("/profile");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        PositionsDAO positionsDAO = dao.getPositionsDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();

        UserInfo userInfo = userInfoDAO.getUserInfoById(id);
        List<Positions> positions = positionsDAO.getTable();

        request.setAttribute("userInfo", userInfo);
        request.setAttribute("positions", positions);
        request.getRequestDispatcher("jsp/profile/editProfile.jsp").forward(request, response);
    }

    private static Date getDateFromString(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = null;
        try {
            parsed = format.parse(date);
        } catch (ParseException e) {
            log.error("getDateFromString: ", e);
        }
        return new Date(parsed.getTime());
    }

}
