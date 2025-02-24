package lk.ijse.gdse.supermarket.dao;

import lk.ijse.gdse.supermarket.dao.Custom.Impl.CustomerDaoImpl;

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
        CUSTOMER,
    }
    public SuperDao getDao(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDaoImpl();

                default:
                    return null;
        }
    }
}
