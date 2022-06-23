package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.Role;
import com.superjahiz.api.domain.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Post Methods
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    // Get Methods
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    // Put Methods
    public void updateRole(Long id, Role newRole) {
        Role roleToUpdate = roleRepository.findById(id).get();
        roleToUpdate.setName(newRole.getName()!=null ? newRole.getName() : roleToUpdate.getName());
        roleRepository.save(roleToUpdate);
    }

    // Delete Methods
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
