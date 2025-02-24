package lk.ijse.gdse.supermarket.model;

import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.dao.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * --------------------------------------------
 * Author: R.I.B. Shamodha Sahan Rathnamalala
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 10/1/2024 4:08 PM
 * Project: Supermarket
 * --------------------------------------------
 **/

public class CustomerModel {


    /**
     * @param selectedCusId: The ID of the customer to find.
     * @return CustomerDTO: Returns a CustomerDTO object containing the customer's details if found, otherwise returns null.
     * @throws SQLException: If any SQL-related error occurs during the query execution.
     * @findById: Finds a customer by their ID.
     * This method retrieves customer data for a specific customer ID from the 'customer' table and creates a CustomerDTO object with the retrieved data.
     **/
    public CustomerDTO findById(String selectedCusId) throws SQLException {
        ResultSet rst = Util.execute("select * from customer where customer_id=?", selectedCusId);

        if (rst.next()) {
            return new CustomerDTO(
                    rst.getString(1),  // Customer ID
                    rst.getString(2),  // Name
                    rst.getString(3),  // NIC
                    rst.getString(4),  // Email
                    rst.getString(5)   // Phone
            );
        }
        return null;
    }
}






