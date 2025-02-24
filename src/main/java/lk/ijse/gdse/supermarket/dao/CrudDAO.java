package lk.ijse.gdse.supermarket.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDao {
    ArrayList<T> getALL ();
    boolean save (T dto);
    void update (T dto);
    void delete (T dto);
    boolean exist(String id) ;
    String generateNewId() throws SQLException;
    T search(String id);
}
