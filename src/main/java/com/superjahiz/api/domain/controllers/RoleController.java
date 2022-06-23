package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.Role;
import com.superjahiz.api.domain.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    // Post Methods
    @PostMapping("/add")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    // Get Methods
    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable("id") long id) {
        return roleService.getRoleById(id);
    }

    // Put Methods
    @PutMapping("/edit/{id}")
    public void updateRole(@PathVariable("id") long id, @RequestBody Role role) {
        roleService.updateRole(id, role);
    }

    // Delete Methods
    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable("id") long id) {
        roleService.deleteRole(id);
    }
}
