package lk.ijse.gdse.supermarket.bo.Custom.impl;

import lk.ijse.gdse.supermarket.bo.Custom.ItemBO;
import lk.ijse.gdse.supermarket.dao.Custom.ItemDAO;
import lk.ijse.gdse.supermarket.dao.DAOFactory;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.SQLException;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOType.ITEM);
    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        Item item= itemDAO.search(id);
       return new ItemDTO(item.getItemId(),item.getItemName(),item.getQuantity(),item.getPrice());
    }
}
