package services.impl;

import enteties.Order;
import enteties.Product;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

    public static final int DEFAULT_ORDER_CAPACITY = 10;
    private static DefaultOrderManagementService instance;

    private Product [] order;

    {
        order = new Product[DEFAULT_ORDER_CAPACITY];
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }
    @Override
    public void addOrder(Order order) {
        //TODO
    }

    @Override
    public Order[] getOrderByUserId(int userId) {
        return null;//TODO
    }

    @Override
    public Order[] getOrders() {
        return null;//TODO
    }

    void clearServiceState(){
        //TODO
    }
}
