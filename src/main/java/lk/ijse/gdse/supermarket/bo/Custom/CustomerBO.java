package lk.ijse.gdse.supermarket.bo.Custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    String getNextCustomerId() throws SQLException;
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException;
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException;
}
