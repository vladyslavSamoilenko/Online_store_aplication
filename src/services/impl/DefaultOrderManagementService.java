package services.impl;

import enteties.Order;
import services.OrderManagementService;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {

    public static final int DEFAULT_ORDER_CAPACITY = 10;
    private static DefaultOrderManagementService instance;

    private static Order[] orders;
    private static int index = 0;
    private static int totalCount = 0;

    {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) {
            return;
        } else {
            if (orders.length <= index) {
                orders = Arrays.copyOf(orders, orders.length << 1);
            }
            orders[index++] = order;
            totalCount++;
        }

    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        if (totalCount == 0) {
            return new Order[0];
        }

        int count = 0;
        for (Order order : orders) {
            if (order == null) {
                break;
            } else if (order.getCustomerId() == userId) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order");
            return new Order[0];
        }

        Order[] userOrders = new Order[count];
        int index = 0;

        for (Order order : orders) {
            if (order == null) {
                break;
            } else if (order.getCustomerId() == userId) {
                userOrders[index++] = order;
            }
        }
        return userOrders;

    }

    @Override
    public Order[] getOrders() {
        int count = 0;
        for (Order order: orders){
            if(order != null){
                count++;
            }
        }

        int index = 0;
        Order [] nonNullOrders = new Order[count];
        for (Order order: orders){
            if(order != null){
                nonNullOrders[index++] = order;
            }
        }
        return nonNullOrders;
    }

    void clearServiceState() {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
        index = 0;
    }


}
