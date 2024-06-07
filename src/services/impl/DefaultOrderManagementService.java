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
    private static int index = 0;
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
        if (order != null){
            allOrders[index++] = order;
        }
    }

    @Override
    public Order[] getOrderByUserId(int userId) {
        int count = 0;
        for (Order order: allOrders){
            if(order.getCustomerId() == userId){
                count++;
            }
        }

        int index = 0;
        Order [] newOrders = new Order[count];
        for (Order order: allOrders){
            newOrders[index++] = order;
        }
        return newOrders;
    }

    @Override
    public Order[] getOrders() {
        return allOrders;
    }

    void clearServiceState(){
        orders = new Product[DEFAULT_ORDER_CAPACITY];
        index = 0;
    }
}
