package lk.ijse.gdse.supermarket.model;

import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.dao.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ItemModel {


    /**
     * @param orderDetailsDTO: The OrderDetailsDTO object containing the order details (item ID and quantity to reduce).
     * @return boolean: Returns true if the item's quantity is successfully updated, otherwise returns false.
     * @throws SQLException: If any SQL-related error occurs during the query execution.
     * @reduceQty: Reduces the quantity of an item after an order is placed.
     * This method updates the 'item' table, reducing the quantity of a specific item based on the quantity ordered.
     **/
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException {
        // Execute SQL query to update the item quantity in the database
        return Util.execute(
                "update item set quantity = quantity - ? where item_id = ?",
                orderDetailsDTO.getQuantity(),   // Quantity to reduce
                orderDetailsDTO.getItemId()      // Item ID
        );
    }
}

