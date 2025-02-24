package lk.ijse.gdse.supermarket.bo.Custom.impl;

import lk.ijse.gdse.supermarket.bo.Custom.ItemBO;
import lk.ijse.gdse.supermarket.dao.Custom.ItemDAO;
import lk.ijse.gdse.supermarket.dao.DAOFactory;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOType.ITEM);

    @Override
    public boolean saveItem(ItemDTO item) throws SQLException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO item) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItem(ItemDTO item) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemDTO> getAllItemList() throws SQLException {
        ArrayList<ItemDTO> list = new ArrayList<>();
        ArrayList<Item>items = itemDAO.getALL();
        for (Item item : items) {
            list.add(new ItemDTO(item.getItemId(),item.getItemName(),item.getQuantity(),item.getPrice()));
        }
        return list;
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        Item item= itemDAO.search(id);
       return new ItemDTO(item.getItemId(),item.getItemName(),item.getQuantity(),item.getPrice());
    }

    @Override
    public ArrayList<String> getAllItemIds() throws SQLException {
        return itemDAO.getAllItemIds();
    }

    @Override
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException {
        return itemDAO.reduceQty(new OrderDetailsDTO(
                orderDetailsDTO.getOrderId(),
                orderDetailsDTO.getItemId(),
                orderDetailsDTO.getQuantity(),
                orderDetailsDTO.getPrice()
        ));
    }
}
