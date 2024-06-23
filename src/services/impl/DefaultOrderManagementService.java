package services.impl;

import enteties.Order;
import enteties.impl.DefaultOrder;
import services.OrderManagementService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultOrderManagementService implements OrderManagementService {

    private static DefaultOrderManagementService instance;
    private static List<Order> orders;

    {
        orders = new ArrayList<>();
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
        }
        orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {

         int count = 0;
        for (Order order : orders) {
            if (order == null) {
                break;
            } else if (order.getCustomerId() == userId) {
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order");
            return new ArrayList<>();
        }

        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order == null) {
                break;
            } else if (order.getCustomerId() == userId) {
                userOrders.add(order);
            }
        }
        return userOrders;

    }

    @Override
    public List<Order> getOrders() {
        List<Order> nonNullOrders = new ArrayList<>();
        for (Order order: orders){
            if (order != null){
                nonNullOrders.add(order);
            }
        }
        return nonNullOrders;
    }

    void clearServiceState() {
        orders.clear();
    }


}
