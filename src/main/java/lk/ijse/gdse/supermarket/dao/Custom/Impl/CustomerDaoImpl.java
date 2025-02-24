package lk.ijse.gdse.supermarket.dao.Custom.Impl;

import lk.ijse.gdse.supermarket.dao.Custom.CustomerDao;
import lk.ijse.gdse.supermarket.dao.Util;
import lk.ijse.gdse.supermarket.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public ArrayList<Customer> getALL() {
        return null;
    }

    @Override
    public boolean save(Customer dto) {
        return false;
    }

    @Override
    public void update(Customer dto) {

    }

    @Override
    public void delete(Customer dto) {

    }

    @Override
    public boolean exist(String id) {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException {
        ResultSet rst = Util.execute("select customer_id from customer order by customer_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1); // Last customer ID
            String substring = lastId.substring(1); // Extract the numeric part
            int i = Integer.parseInt(substring); // Convert the numeric part to integer
            int newIdIndex = i + 1; // Increment the number by 1
            return String.format("C%03d", newIdIndex); // Return the new customer ID in format Cnnn
        }
        return "C001";
    }

    @Override
    public Customer search(String id) {
        return null;
    }
}
