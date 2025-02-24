package lk.ijse.gdse.supermarket.dao;

import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDao {
    ArrayList<T> getALL ();
    boolean save (T dto);
    void update (T dto);
    void delete (T dto);
    boolean exist(String id) ;
    String generateNewId();
    T search(String id);
}
