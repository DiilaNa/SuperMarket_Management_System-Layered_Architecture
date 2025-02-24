package lk.ijse.gdse.supermarket.dao.Custom.Impl;

import lk.ijse.gdse.supermarket.dao.Custom.ItemDAO;
import lk.ijse.gdse.supermarket.dao.Util;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getALL() throws SQLException {
       ResultSet rst = Util.execute("select * from item");
       ArrayList<Item> items = new ArrayList<>();
       while (rst.next()) {
           items.add(new Item(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getInt(3),
                   rst.getDouble(4)
           ));
       }
       return items;
    }

    @Override
    public boolean save(Item entity) throws SQLException {
       return Util.execute("insert into item values(?,?,?,?)",
               entity.getItemId(),
               entity.getItemName(),
               entity.getQuantity(),
               entity.getPrice()
               );
    }

    @Override
    public boolean update(Item entity) throws SQLException {
        return Util.execute("update item set name=?,quantity=?,price=? where item_id=?",
                entity.getItemName(),
                entity.getQuantity(),
                entity.getPrice(),
                entity.getItemId()
                );
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

    @Override
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException {
        return Util.execute(
                "update item set quantity = quantity - ? where item_id = ?",
                orderDetailsDTO.getQuantity(),   // Quantity to reduce
                orderDetailsDTO.getItemId()      // Item ID
        );
    }
}
