package servlets;

import DAO.DAOFactory;
import DAO.MessagesDAO;
import DAO.MySQL.MySQLDAO;
import DAO.UserInfoDAO;
import entities.LastMessage;
import entities.Messages;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HackuunaMatata on 17.01.2017.
 */
@WebServlet(name = "Messages", urlPatterns = "/messages")
public class MessagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySQLDAO dao = DAOFactory.getInstanceMySQL();
        MessagesDAO messagesDAO = dao.getMessagesDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();
        int fromId;
        String from;
        String colleague;
        String messageText;
        Timestamp date;
        int countUnread;

        HashMap<Integer, Messages> lastMessages = messagesDAO.getLastMessagesForUser(id);
        System.out.println(lastMessages);

        List<LastMessage> messages = new ArrayList<>();

        for (Integer integer : lastMessages.keySet()) {
            Messages message = lastMessages.get(integer);
            fromId = message.getId_from();
            from = fromId == id ? "You: " : "";
            colleague = userInfoDAO.getUserInfoById(integer).getName() + " " + userInfoDAO.getUserInfoById(integer).getSurname();
            messageText = message.getText();
            date = message.getDatetime();
            countUnread = messagesDAO.countUnreadMessages(integer, id);
            messages.add(new LastMessage(from, colleague, integer, messageText, date, countUnread));
        }

        System.out.println(messages);

        request.setAttribute("lastMessages", messages);
        request.getRequestDispatcher("/jsp/messages.jsp").forward(request, response);
    }
}
