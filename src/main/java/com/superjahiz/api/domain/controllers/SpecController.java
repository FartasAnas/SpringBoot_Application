package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.Spec;
import com.superjahiz.api.domain.services.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spec")
@PreAuthorize("hasAuthority('ADMIN')")
public class SpecController {
    @Autowired
    private SpecService specService;

    // Post Methods
    @RequestMapping("/add")
    public void addSpec(@RequestBody Spec spec) {
        specService.addSpec(spec);
    }

    // Get Methods
    @RequestMapping("/all")
    public List<Spec> getAllSpecs() {
        return specService.getAllSpecs();
    }
    @RequestMapping("/{id}")
    public Spec getSpecById(@PathVariable("id") long id) {
        return specService.getSpecById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updateSpec(@PathVariable("id") long id, @RequestBody Spec newSpec) {
        specService.updateSpec(id, newSpec);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deleteSpec(@PathVariable("id") long id) {
        specService.deleteSpec(id);
    }
}
