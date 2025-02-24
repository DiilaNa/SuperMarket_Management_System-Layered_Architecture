package lk.ijse.gdse.supermarket.dao.Custom.Impl;

import lk.ijse.gdse.supermarket.dao.Custom.ItemDAO;
import lk.ijse.gdse.supermarket.dao.Util;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getALL() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Item dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Item dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean exist(String id) {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException {
        return "";
    }

    @Override
    public Item search(String id) throws SQLException {
        ResultSet rst = Util.execute("select * from item where item_id=?", id);

        if (rst.next()) {
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllItemIds() throws SQLException {
        ResultSet rst = Util.execute("select item_id from item");
        ArrayList<String> itemIds = new ArrayList<>();

        while (rst.next()) {
            itemIds.add(rst.getString(1));
        }
        return itemIds;
    }
}
