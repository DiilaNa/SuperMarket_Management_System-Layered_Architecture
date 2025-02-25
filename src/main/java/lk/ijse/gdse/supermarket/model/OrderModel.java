package lk.ijse.gdse.supermarket.model;

import lk.ijse.gdse.supermarket.db.DBConnection;
import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.dao.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * --------------------------------------------
 * Author: R.I.B. Shamodha Sahan Rathnamalala
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 10/9/2024 12:15 PM
 * Project: Supermarket
 * --------------------------------------------
 **/

public class OrderModel {

    // @orderDetailsModel: A reference to the OrderDetailsModel to handle order details saving
    private final OrderDetailsModel orderDetailsModel = new OrderDetailsModel();


    /**
     * @saveOrder: Saves the order and its details in the database.
     * It handles the transaction by saving the order in the orders table and the order details in the order_details table.
     * If any part of the process fails, it rolls back the transaction to maintain data consistency.
     *
     * @param orderDTO: The DTO containing order data to be saved in the database.
     * @return boolean: Returns true if both the order and its details are saved successfully, otherwise false.
     * @throws SQLException: If any SQL-related issues occur during the saving process.
     **/
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException {
        // @connection: Retrieves the current connection instance for the database
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            // @autoCommit: Disables auto-commit to manually control the transaction
            connection.setAutoCommit(false); // 1

            // @isOrderSaved: Saves the order details into the orders table
            boolean isOrderSaved = Util.execute(
                    "insert into orders values (?,?,?)",
                    orderDTO.getOrderId(),
                    orderDTO.getCustomerId(),
                    orderDTO.getOrderDate()
            );
            // If the order is saved successfully
            if (isOrderSaved) {
                // @isOrderDetailListSaved: Saves the list of order details
                boolean isOrderDetailListSaved = orderDetailsModel.saveOrderDetailsList(orderDTO.getOrderDetailsDTOS());
                if (isOrderDetailListSaved) {
                    // @commit: Commits the transaction if both order and details are saved successfully
                    connection.commit(); // 2
                    return true;
                }
            }
            // @rollback: Rolls back the transaction if order details saving fails
            connection.rollback(); // 3
            return false;
        } catch (Exception e) {
            // @catch: Rolls back the transaction in case of any exception
            connection.rollback();
            return false;
        } finally {
            // @finally: Resets auto-commit to true after the operation
            connection.setAutoCommit(true); // 4
        }
    }
}

