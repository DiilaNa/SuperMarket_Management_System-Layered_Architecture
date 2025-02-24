package lk.ijse.gdse.supermarket.bo;

import lk.ijse.gdse.supermarket.bo.Custom.impl.CustomerBOImpl;
import lk.ijse.gdse.supermarket.bo.Custom.impl.ItemBOImpl;

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
        CUSTOMER,ITEM
    }
    public SuperBO getBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
                case ITEM:
                    return new ItemBOImpl();
                default:
                    return null;
        }
    }
}
