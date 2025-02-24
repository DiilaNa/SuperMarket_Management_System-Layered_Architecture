package lk.ijse.gdse.supermarket.model;

import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.dao.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ItemModel {

    /**
     * @return ArrayList<String>: A list of item IDs retrieved from the database.
     * @throws SQLException: If any SQL-related error occurs during the query execution.
     * @getAllItemIds: Retrieves all item IDs from the 'item' table.
     * This method executes an SQL query to get all the item IDs, stores them in an ArrayList, and returns the list.
     **/
    public ArrayList<String> getAllItemIds() throws SQLException {
        // Execute SQL query to get all item IDs
        ResultSet rst = Util.execute("select item_id from item");

        // Create an ArrayList to store the item IDs
        ArrayList<String> itemIds = new ArrayList<>();

        // Iterate through the result set and add each item ID to the list
        while (rst.next()) {
            itemIds.add(rst.getString(1));
        }

        // Return the list of item IDs
        return itemIds;
    }


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

