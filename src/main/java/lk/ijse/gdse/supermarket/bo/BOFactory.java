package lk.ijse.gdse.supermarket.bo;

import lk.ijse.gdse.supermarket.bo.Custom.impl.CustomerBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOType {
        CUSTOMER
    }
    public SuperBO getBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
                default:
                    return null;
        }
    }
}
