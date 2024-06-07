package services.impl;

import enteties.Order;
import enteties.Product;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

    public static final int DEFAULT_ORDER_CAPACITY = 10;
    public static final int DEFAULT_ALL_ORDER_CAPACITY = 100;
    private static DefaultOrderManagementService instance;

    private Product [] orders;
    private static Order [] allOrders;
    {
        allOrders = new Order[DEFAULT_ALL_ORDER_CAPACITY];
    }

    {
        orders = new Product[DEFAULT_ORDER_CAPACITY];
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
