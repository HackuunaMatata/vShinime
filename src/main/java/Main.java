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
        //usersDAO.addUser("sasha", "sasha", "sasha");
        System.out.println(usersDAO.getTable());
        System.out.println(usersDAO.getIdByLogin("123"));
        System.out.println(usersDAO.getUserById(2));
        System.out.println(usersDAO.getUserById(10));

    }
}
