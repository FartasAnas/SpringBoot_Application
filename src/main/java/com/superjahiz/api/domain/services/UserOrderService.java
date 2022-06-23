package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.OrderLine;
import com.superjahiz.api.domain.entities.Product;
import com.superjahiz.api.domain.entities.UserOrder;
import com.superjahiz.api.domain.repositories.ProductRepository;
import com.superjahiz.api.domain.repositories.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderLineService orderLineService;

    // Post Methods
    public void addUserOrder(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }
    // Get Methods
    public List<UserOrder> getAllUserOrders() {
        return userOrderRepository.findAll();
    }
    public UserOrder getUserOrderById(Long id) {
        return userOrderRepository.findById(id).get();
    }

    // Put Methods
    public void updateUserOrder(Long id, UserOrder newUserOrder) {
        UserOrder userOrderToUpdate = userOrderRepository.findById(id).get();
        userOrderToUpdate.setShippingAddress(newUserOrder.getShippingAddress()!=null ? newUserOrder.getShippingAddress() : userOrderToUpdate.getShippingAddress());
        userOrderToUpdate.setTotalPrice(newUserOrder.getTotalPrice());
        userOrderRepository.save(userOrderToUpdate);
    }

    // Delete Methods
    public void deleteUserOrder(Long id) {
        userOrderRepository.deleteById(id);
    }
}
