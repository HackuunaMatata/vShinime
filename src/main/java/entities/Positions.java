package entities;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public class Positions {
    int id;
    String name;

    public Positions(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
