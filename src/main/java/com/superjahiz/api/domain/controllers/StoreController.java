package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.Store;
import com.superjahiz.api.domain.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;


@RestController
@RequestMapping("/store")
@PreAuthorize("hasAuthority('ADMIN')")
public class StoreController {
    @Autowired
    private StoreService storeService;

    // Post Methods
    @RequestMapping("/add")
    public void addStore(@RequestBody Store store) {
        storeService.addStore(store);
    }

    // Get Methods
    @RequestMapping("/all")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }
    @RequestMapping("/{id}")
    public Store getStoreById(@PathVariable("id") long id) {
        return storeService.getStoreById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updateStore(@PathVariable("id") long id, @RequestBody Store newStore) {
        storeService.updateStore(id, newStore);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deleteStore(@PathVariable("id") long id) {
        storeService.deleteStore(id);
    }

}
