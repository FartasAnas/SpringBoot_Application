package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.AppUser;
import com.superjahiz.api.domain.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    // Post Methods
    public void addAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    // Get Methods
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }
    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id).get();
    }

    // Put Methods
    public void updateAppUser(Long id, AppUser newAppUser) {
        AppUser appUserToUpdate = appUserRepository.findById(id).get();
        appUserToUpdate.setUsername(newAppUser.getUsername()!=null ? newAppUser.getUsername() : appUserToUpdate.getUsername());
        appUserToUpdate.setEmail(newAppUser.getEmail()!=null ? newAppUser.getEmail() : appUserToUpdate.getEmail());
        appUserToUpdate.setPassword(newAppUser.getPassword()!=null ? newAppUser.getPassword() : appUserToUpdate.getPassword());
        appUserToUpdate.setFirstName(newAppUser.getFirstName()!=null ? newAppUser.getFirstName() : appUserToUpdate.getFirstName());
        appUserToUpdate.setLastName(newAppUser.getLastName()!=null ? newAppUser.getLastName() : appUserToUpdate.getLastName());
        appUserRepository.save(appUserToUpdate);
    }

    // Delete Methods
    public void deleteAppUser(Long id) {
        appUserRepository.deleteById(id);
    }
}
