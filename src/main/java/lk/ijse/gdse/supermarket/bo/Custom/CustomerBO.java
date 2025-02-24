package lk.ijse.gdse.supermarket.bo.Custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    String getNextCustomerId() throws SQLException;
}
