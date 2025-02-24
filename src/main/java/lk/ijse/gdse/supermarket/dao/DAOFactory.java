package lk.ijse.gdse.supermarket.dao;

import lk.ijse.gdse.supermarket.dao.Custom.Impl.CustomerDaoImpl;
import lk.ijse.gdse.supermarket.dao.Custom.Impl.ItemDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOType {
        CUSTOMER,ITEM
    }
    public SuperDao getDao(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDaoImpl();
                    case ITEM:
                        return new ItemDaoImpl();
                default:
                    return null;
        }
    }
}
