package entities;

import java.sql.Date;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class UserInfo {
    private int id;
    private String name;
    private String surname;
    private int positionId;
    private Date bday;
    private String magazine;
    private String photo;

    public UserInfo(int id, String name, String surname, int positionId, Date bday, String magazine, String photo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.positionId = positionId;
        this.bday = bday;
        this.magazine = magazine;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", positionId=" + positionId +
                ", bday=" + bday +
                ", magazine='" + magazine + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
