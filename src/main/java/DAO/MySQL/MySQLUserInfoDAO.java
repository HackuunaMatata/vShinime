package DAO.MySQL;

import DAO.UserInfoDAO;
import entities.UserInfo;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class MySQLUserInfoDAO extends MySQLDAO implements UserInfoDAO {
    private static final Logger log = Logger.getLogger(MySQLUserInfoDAO.class);


    public void addUserInfo(int id, String name, String surname, int positionId, Date bday, String magazine, String photo) {
        insert("userinfo (`id`, `name`, `surname`, `position_id`, `bday`, `magazine`, `photo`)",
                "" + id + ", '" + name + "', '" + surname + "', " + positionId + ", '" + bday + "', '" + magazine + "', '" + photo + "'");
    }

    public List<UserInfo> getTable() {
        ResultSet resultSet = select("userinfo", "1");
        return getListFromResultSet(resultSet);
    }

    public UserInfo getUserInfoById(int id) {
        ResultSet resultSet = select("userinfo", "id='" + id + "'");
        try {
            resultSet.next();
            UserInfo info = new UserInfo(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getInt("position_id"),
                    resultSet.getDate("bday"),
                    resultSet.getString("magazine"),
                    resultSet.getString("photo"));
            return info;
        } catch (SQLException e) {
            log.error("getUserInfoById: ", e);
        }
        return null;
    }

    public List<UserInfo> getForHead(String magazine) {
        String condition = "magazine='" + magazine + "' AND position_id=3 OR position_id=2 OR position_id=1 OR position_id=4 OR position_id=5";
        ResultSet resultSet = select("userinfo", condition);
        return getListFromResultSet(resultSet);
    }

    public List<UserInfo> getForJournalist(String magazine) {
        String condition = "magazine='" + magazine + "' AND (position_id=3 OR position_id=1 OR position_id=5)";
        ResultSet resultSet = select("userinfo", condition);
        return getListFromResultSet(resultSet);
    }

    public List<UserInfo> getForOwner() {
        String condition = "position_id=1 OR position_id=2 OR position_id=5 OR position_id=4";
        ResultSet resultSet = select("userinfo", condition);
        return getListFromResultSet(resultSet);
    }

    private List<UserInfo> getListFromResultSet(ResultSet resultSet) {
        List<UserInfo> userInfo = new ArrayList<>();
        try {
            while(resultSet.next()) {
                UserInfo info = new UserInfo(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("position_id"),
                        resultSet.getDate("bday"),
                        resultSet.getString("magazine"),
                        resultSet.getString("photo"));
                userInfo.add(info);
            }
            return userInfo;
        } catch (SQLException e) {
            log.error("getListFromResultSet: ", e);
        }
        return null;
    }

    public void updateUserInfo(String newName, String newSurname, Date bday, int newPositionId, String newMagazine, int id) {
        String set;
        String fullName;
        String fullWork;
        String setName = newName == null ? "" : "name='" + newName + "'";
        String setSurname = newSurname == null ? "" : "surname='" + newSurname + "'";
        String setPositionId = newPositionId == -1 ? "" : "position_id=" + newPositionId;
        String setMagazine = newMagazine == null ? "" : "magazine='" + newMagazine + "'";

        if (!setName.equals("") && !setSurname.equals("")) fullName = setName + ", " + setSurname;
        else fullName = setName + setSurname;

        if (!setPositionId.equals("") && !setMagazine.equals("")) fullWork = setPositionId + ", " + setMagazine;
        else fullWork = setPositionId + setMagazine;

        if (!fullName.equals("") && !fullWork.equals("")) set = fullName + ", " + fullWork;
        else set = fullName + fullWork;

        if (!set.equals("")) set += ", bday='" + bday + "'";
        else set += "bday='" + bday + "'";

        update("userinfo", set, "id='" + id + "'");

    }

    public void updateUserPhoto(String photo, int id) {
        String set = photo == null ? "" : "photo='" + photo + "'";
        update("userinfo", set, "id='" + id + "'");
    }

}
