package lk.ijse.gdse.supermarket.bo.Custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;

import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    String generateNewOrderId() throws SQLException;
}
