package DAO;

import entities.UserInfo;

import java.sql.Date;
import java.util.List;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public interface UserInfoDAO {
    void addUserInfo(int id, String name, String surname, int positionId, Date bday, String magazine, String photo);
    List<UserInfo> getTable();
    UserInfo getUserInfoById(int id);
    void updateUserInfo(String newName, String newSurname, Date bday, int newPositionId, String newMagazine, int id);
    List<UserInfo> getForHead(String magazine);
    List<UserInfo> getForJournalist(String magazine);
    List<UserInfo> getForOwner();
    void updateUserPhoto(String photo, int id);
}
