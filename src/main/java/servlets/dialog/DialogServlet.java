package servlets.dialog;

import DAO.DAOFactory;
import DAO.MessagesDAO;
import DAO.UserInfoDAO;
import entities.Messages;
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
 * Created by HackuunaMatata on 18.01.2017.
 */
@WebServlet(name = "Dialog", urlPatterns = "/dialog")
public class DialogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        MessagesDAO messagesDAO = dao.getMessagesDAO();

        int id_guest = Integer.parseInt(request.getParameter("guestId"));
        String text = request.getParameter("text");

        messagesDAO.addMessage(id, id_guest, text);

        response.sendRedirect("dialog?id=" + id_guest);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();
        DAOFactory dao = DAOFactory.getInstanceDAO();
        MessagesDAO messagesDAO = dao.getMessagesDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();

        int id_guest = Integer.parseInt(request.getParameter("id"));

        UserInfo guest = userInfoDAO.getUserInfoById(id_guest);
        UserInfo userInfo = userInfoDAO.getUserInfoById(id);

        List<Messages> nMessages = messagesDAO.getLastNMessages(id, id_guest, 10);
        messagesDAO.readMessages(id_guest, id);

        request.getSession().setAttribute("messages", messagesDAO.countAllUnreadMessages(id));
        request.setAttribute("nMessages", nMessages);
        request.setAttribute("guest", guest);
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("/jsp/dialog/dialog.jsp").forward(request, response);

    }
}
