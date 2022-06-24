package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.AppUser;
import com.superjahiz.api.domain.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appUser")
@PreAuthorize("hasAuthority('ADMIN')")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    // Post Methods
    @RequestMapping("/add")
    public void addAppUser(@RequestBody AppUser appUser) {
        appUserService.addAppUser(appUser);
    }

    // Get Methods
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/all")
    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/{id}")
    public AppUser getAppUserById(@PathVariable("id") long id) {
        return appUserService.getAppUserById(id);
    }

    // Put Methods
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/edit/{id}")
    public void updateAppUser(@PathVariable("id") long id, @RequestBody AppUser newAppUser) {
        appUserService.updateAppUser(id, newAppUser);
    }

    // Delete Methods
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    public void deleteAppUser(@PathVariable("id") long id) {
        appUserService.deleteAppUser(id);
    }
}
