package DAO;

import entities.Positions;

import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public interface PositionsDAO {
    public List<Positions> getTable();
    public Positions getPositionById(int id);
}
