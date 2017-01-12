import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.UserInfoDAO;
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
        //System.out.println(usersDAO.getTable());
        //System.out.println(usersDAO.getIdByLogin("123"));
        //System.out.println(usersDAO.getUserById(2));
        //System.out.println(usersDAO.getUserById(10));
        //usersDAO.updateUser("qwerty", null, 1);
        //usersDAO.updateUser(null, "qwerty", 2);
        // usersDAO.updateUser("3", "3", 3);

        UserInfoDAO userInfoDAO = sql.getUserInfoDAO();
        //userInfoDAO.addUserInfo(2, "po", "po", 3, 2016-02-01, "fgh", "pou"); //КАК ДАТУ?
        //System.out.println(userInfoDAO.getTable());
        //System.out.println(userInfoDAO.getUserInfoById(1));
        userInfoDAO.updateUserInfo("alex", null, 2, null, "df", 1);
    }
}
