package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.UserOrder;
import com.superjahiz.api.domain.services.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userOrder")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    // Post Methods
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @RequestMapping("/add")
    public void addUserOrder(@RequestBody UserOrder userOrder) {
        userOrderService.addUserOrder(userOrder);
    }

    // Get Methods
    @RequestMapping("/all")
    public List<UserOrder> getAllUserOrders() {
        return userOrderService.getAllUserOrders();
    }
    @RequestMapping("/{id}")
    public UserOrder getUserOrderById(@PathVariable("id") long id) {
        return userOrderService.getUserOrderById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updateUserOrder(@PathVariable("id") long id, @RequestBody UserOrder newUserOrder) {
        userOrderService.updateUserOrder(id, newUserOrder);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deleteUserOrder(@PathVariable("id") long id) {
        userOrderService.deleteUserOrder(id);
    }
}
