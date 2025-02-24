package lk.ijse.gdse.supermarket.bo.Custom.impl;

import lk.ijse.gdse.supermarket.bo.Custom.CustomerBO;
import lk.ijse.gdse.supermarket.dao.Custom.CustomerDao;
import lk.ijse.gdse.supermarket.dao.DAOFactory;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    CustomerDao customerDao = (CustomerDao) DAOFactory.getInstance().getDao(DAOFactory.DAOType.CUSTOMER);

    @Override
    public String getNextCustomerId() throws SQLException {
        return customerDao.generateNewId();
    }
}
