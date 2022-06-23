package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.Store;
import com.superjahiz.api.domain.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    // Post Methods
    public void addStore(Store store) {
        storeRepository.save(store);
    }

    // Get Methods
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).get();
    }

    // Put Methods
    public void updateStore(Long id, Store newStore) {
        Store storeToUpdate = storeRepository.findById(id).get();
        storeToUpdate.setDomainName(newStore.getDomainName()!=null ? newStore.getDomainName() : storeToUpdate.getDomainName());
        storeToUpdate.setLogoUrl(newStore.getLogoUrl()!=null ? newStore.getLogoUrl() : storeToUpdate.getLogoUrl());
        storeToUpdate.setAccentColor(newStore.getAccentColor()!=null ? newStore.getAccentColor() : storeToUpdate.getAccentColor());
        storeToUpdate.setContrastColor(newStore.getContrastColor()!=null ? newStore.getContrastColor() : storeToUpdate.getContrastColor());
        storeRepository.save(storeToUpdate);
    }

    // Delete Methods
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }


}
