package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.OrderLine;
import com.superjahiz.api.domain.repositories.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;

    // Post Methods
    public void addOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    // Get Methods
    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }
    public OrderLine getOrderLineById(Long id) {
        return orderLineRepository.findById(id).get();
    }

    // Put Methods
    public void updateOrderLine(Long id, OrderLine newOrderLine) {
        OrderLine orderLineToUpdate = orderLineRepository.findById(id).get();
        orderLineToUpdate.setQuantity(newOrderLine.getQuantity());
        orderLineToUpdate.setTotal(newOrderLine.getTotal());
        orderLineRepository.save(orderLineToUpdate);
    }

    // Delete Methods
    public void deleteOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }


}
