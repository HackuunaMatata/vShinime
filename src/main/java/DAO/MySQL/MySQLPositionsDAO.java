package DAO.MySQL;

import DAO.PositionsDAO;
import entities.Positions;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public class MySQLPositionsDAO extends MySQLDAO implements PositionsDAO {
    private static final Logger log = Logger.getLogger(MySQLPositionsDAO.class);

    public List<Positions> getTable() {
        List<Positions> positions = new ArrayList<>();
        ResultSet resultSet = select("positions", "1");
        try {
            while (resultSet.next()) {
                Positions position = new Positions(resultSet.getInt("id"),
                        resultSet.getString("name"));
                positions.add(position);
            }
            return positions;
        } catch (SQLException e) {
            log.error("getTable: ", e);
        }
        return null;
    }

    public Positions getPositionById(int id) {
        ResultSet resultSet = select("positions", "id='" + id + "'");
        try {
            resultSet.next();
            Positions position = new Positions(resultSet.getInt("id"),
                    resultSet.getString("name"));
            return position;
        } catch (SQLException e) {
            log.error("getPositionById: ", e);
        }
        return null;
    }
}
