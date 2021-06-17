package me.simran.repository;

import me.simran.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@ResponseBody
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public List<Order> getAllOrders() {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.getAllOrders", Order.class);
        return query.getResultList();
    }

    @Override
    public Order getOrderById(String id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> getAllOrdersWithinInterval(java.sql.Date startTime, java.sql.Date endTime) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.getOrdersWithinInterval", Order.class);
        query.setParameter("start", startTime);
        query.setParameter("end", endTime);
        return query.getResultList();
    }

    @Override
    public List<Order> getTop10OrdersWithHighestDollarAmountInZip(String zip) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.getTop10OrdersWithHighestDollarAmountInZip", Order.class);
        query.setParameter("zipCode",zip);
        return query.setMaxResults(10).getResultList();
    }

    @Override
    public Order placeOrder(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Override
    public Order update(Order order) {
        return entityManager.merge(order);
    }
}
