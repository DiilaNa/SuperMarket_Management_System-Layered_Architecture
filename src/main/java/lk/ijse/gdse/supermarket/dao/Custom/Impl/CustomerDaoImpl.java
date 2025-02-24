package lk.ijse.gdse.supermarket.dao.Custom.Impl;

import lk.ijse.gdse.supermarket.dao.Custom.CustomerDao;
import lk.ijse.gdse.supermarket.entity.Customer;

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
    public String generateNewId() {
        return "";
    }

    @Override
    public Customer search(String id) {
        return null;
    }
}
