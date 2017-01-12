import DAO.*;
import DAO.MySQL.MySQLDAO;
import entities.Articles;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello");

        MySQLDAO sql = DAOFactory.getInstanceMySQL();
        UsersDAO usersDAO = sql.getUsersDAO();
        //usersDAO.addUser("sasha", "sasha", "sasha");
        //System.out.println(usersDAO.getTable());
        //System.out.println(usersDAO.getIdByLogin("123"));
        //System.out.println(usersDAO.getUserById(2));
        //System.out.println(usersDAO.getUserById(10));
        //usersDAO.updateUser("qwerty", null, 1);
        //usersDAO.updateUser(null, "qwerty", 2);
        // usersDAO.updateUser("3", "3", 3);

        UserInfoDAO userInfoDAO = sql.getUserInfoDAO();
        //new GregorianCalendar(116, 1, 1).getTimeInMillis()
        //userInfoDAO.addUserInfo(2, "po", "po", 3,  new Date(116, 01, 01), "fgh", "pou");
        //System.out.println(userInfoDAO.getTable());
        //System.out.println(userInfoDAO.getUserInfoById(1));
        //userInfoDAO.updateUserInfo("alex", null, 2, null, "df", 1);

        PositionsDAO positionsDAO = sql.getPositionsDAO();
        //System.out.println(positionsDAO.getTable());
        //System.out.println(positionsDAO.getPositionById(2));

        ArticlesDAO articlesDAO = sql.getArticlesDAO();
        //articlesDAO.addArticle(3, "2", "2", new Date(115, 04, 10));
        //System.out.println(articlesDAO.getArticlesByUserId(-1));
        //System.out.println(articlesDAO.getArticlesByUserId(2));
        //articlesDAO.updateArticleForUser("black-white", new Date(116, 00, 22), 1, "zxc");
        //articlesDAO.updateArticleForUser(null, new Date(116, 00, 22), 1, "zxc");
        //articlesDAO.deleteArticleForUser("1", 3);
        //articlesDAO.deleteAllArticlesForUser(3);

        MessagesDAO messagesDAO = sql.getMessagesDAO();
        //messagesDAO.addMessage(3, 2, "ooooo");
        //System.out.println(messagesDAO.getMessages(3, 2));
        //System.out.println(messagesDAO.countUnreadMessages(3, 2));
        //messagesDAO.readMessages(3, 2);
    }
}
