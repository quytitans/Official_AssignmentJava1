package model;

import entity.Order;

import java.util.List;

public interface OrderModel {
    Boolean saveOrder(Order obj);

    Order findOrderById(String ID);

    List<Order> findOrderByTime(long startTime, long endTime);

    List<Order> findAll();
    List<Order> showPaidOrder();

}
