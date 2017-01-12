package DAO;

import entities.UserInfo;

import java.sql.Date;
import java.util.List;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public interface UserInfoDAO {
    public void addUserInfo(int id, String name, String surname, int positionId, Date bday, String magazine, String photo);
    public List<UserInfo> getTable();
    public UserInfo getUserInfoById(int id);
    public void updateUserInfo(String newName, String newSurname, int newPositionId, String newMagazine, String newPhoto, int id);
}
