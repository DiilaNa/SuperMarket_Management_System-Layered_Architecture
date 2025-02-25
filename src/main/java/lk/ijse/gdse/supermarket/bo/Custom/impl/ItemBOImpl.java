package lk.ijse.gdse.supermarket.bo.Custom.impl;

import lk.ijse.gdse.supermarket.bo.Custom.ItemBO;
import lk.ijse.gdse.supermarket.dao.Custom.ItemDAO;
import lk.ijse.gdse.supermarket.dao.DAOFactory;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Item;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOType.ITEM);

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.save(new Item(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getQuantity(),
                itemDTO.getPrice()
        ));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.update(new Item(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getQuantity(),
                itemDTO.getPrice()
        ));
    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return itemDAO.delete(id);
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
        System.out.println("selected id in itemBO IMPL is :"+id);
        Item item= itemDAO.search(id);
        System.out.println("sid came from dao:"+item.getItemId()+" mek ywpu nma:"+id);
        return new ItemDTO(
               item.getItemId(),
               item.getItemName(),
               item.getQuantity(),
               item.getPrice());
    }

    @Override
    public ArrayList<String> getAllItemIds() throws SQLException {
        return itemDAO.getAllItemIds();
    }

    @Override
    public boolean reduceQty(ArrayList<OrderDetailsDTO> orderDetailsDTO) throws SQLException {
        for (OrderDetailsDTO orderDetail : orderDetailsDTO) {
            boolean isUpdated = itemDAO.reduceQty(orderDetail.getItemId(), orderDetail.getQuantity());
            if (!isUpdated) {
                throw new SQLException("Failed to update quantity for Item ID: " + orderDetail.getItemId());

            }
        }
        return true;
    }

    @Override
    public String getNextItemId() throws SQLException {
        return itemDAO.generateNewId();
    }
}
