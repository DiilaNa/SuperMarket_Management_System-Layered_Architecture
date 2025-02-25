package lk.ijse.gdse.supermarket.bo.Custom.impl;

import lk.ijse.gdse.supermarket.bo.Custom.OrderBO;
import lk.ijse.gdse.supermarket.dao.Custom.OrderDAO;
import lk.ijse.gdse.supermarket.dao.DAOFactory;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOType.ORDER);
    @Override
    public String generateNewOrderId() throws SQLException {
        return  orderDAO.generateNewId();
    }
}
