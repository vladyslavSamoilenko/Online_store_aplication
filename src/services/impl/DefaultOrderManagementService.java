package services.impl;

import enteties.Order;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

    public static final int DEFAULT_ORDER_CAPACITY = 10;
    private static DefaultOrderManagementService instance;
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
