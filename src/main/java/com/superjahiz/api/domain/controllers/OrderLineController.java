package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.OrderLine;
import com.superjahiz.api.domain.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderline")
@PreAuthorize("hasAuthority('ADMIN')")
public class OrderLineController {
    @Autowired
    private OrderLineService orderLineService;

    // Post Methods
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @RequestMapping("/add")
    public void addOrderLine(@RequestBody OrderLine orderLine) {
        orderLineService.addOrderLine(orderLine);
    }

    // Get Methods
    @RequestMapping("/all")
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }
    @RequestMapping("/{id}")
    public OrderLine getOrderLineById(@PathVariable("id") long id) {
        return orderLineService.getOrderLineById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updateOrderLine(@PathVariable("id") long id, @RequestBody OrderLine orderLine) {
        orderLineService.updateOrderLine(id, orderLine);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deleteOrderLine(@PathVariable("id") long id) {
        orderLineService.deleteOrderLine(id);
    }

}
