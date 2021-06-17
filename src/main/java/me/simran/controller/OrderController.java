package me.simran.controller;

import me.simran.model.Order;
import me.simran.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="order")
public class OrderController {

    @Autowired
    private OrderService service;

    /** /api/orders */
    @RequestMapping(method= RequestMethod.GET)
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    /** /api/order/id */
    @RequestMapping(method = RequestMethod.GET, value="/id/{id}")
    public Order getOrderById(@PathVariable("id") String orderId){
        return service.getOrderById(orderId);
    }

    /** /api/order/startTime/endTime
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value="{start}/{end}")
    public List<Order> getAllOrdersWithInInterval(@PathVariable("start") String startTime, @PathVariable("end") String endTime){
        return service.getAllOrdersWithinInterval(startTime, endTime);
    }

    /** /api/order/zip */
    @RequestMapping(method = RequestMethod.GET, value="/zip/{zip}")
    public List<Order> top10OrdersWithHighestDollarAmountInZip(@PathVariable("zip") String zip){
        return service.getTop10OrdersWithHighestDollarAmountInZip(zip);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order placeOrder(@RequestBody Order order){
        return service.placeOrder(order);
    }

    /** /api/order/id */
    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void cancelOrder(@PathVariable("id") String orderId){
        service.delete(orderId);
    }

    /** /api/order/id */
    @RequestMapping(method = RequestMethod.PUT, value={"/update/{id}"})
    public Order updateOrder(@PathVariable("id") String orderId,@RequestBody Order order){
        return service.update(orderId, order);
    }
}
