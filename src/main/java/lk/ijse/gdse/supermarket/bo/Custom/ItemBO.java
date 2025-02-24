package lk.ijse.gdse.supermarket.bo.Custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;


public interface ItemBO extends SuperBO {
    ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllItemIds() throws SQLException;
}
