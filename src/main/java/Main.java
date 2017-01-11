import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.UsersDAO;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello");

        MySQLDAO sql = DAOFactory.getInstanceMySQL();
        UsersDAO usersDAO = sql.getUsersDAO();
        usersDAO.addUser("sasha", "sasha", "sasha");


    }
}
