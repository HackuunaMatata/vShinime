package DAO;

import entities.Positions;

import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public interface PositionsDAO {
    List<Positions> getTable();
    Positions getPositionById(int id);
}
