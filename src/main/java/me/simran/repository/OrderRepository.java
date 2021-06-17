package me.simran.repository;

import me.simran.model.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderById(String id);
    List<Order> getAllOrdersWithinInterval(java.sql.Date startTime, java.sql.Date endTime);
    List<Order> getTop10OrdersWithHighestDollarAmountInZip(String zip);
    Order placeOrder(Order order);
    void delete(Order order);
    Order update(Order order);
}
