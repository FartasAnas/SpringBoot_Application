package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.Spec;
import com.superjahiz.api.domain.repositories.SpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecService {
    @Autowired
    private SpecRepository specRepository;

    // Post Methods
    public void addSpec(Spec spec) {
        specRepository.save(spec);
    }

    // Get Methods
    public List<Spec> getAllSpecs() {
        return specRepository.findAll();
    }
    public Spec getSpecById(Long id) {
        return specRepository.findById(id).get();
    }

    // Put Methods
    public void updateSpec(Long id, Spec newSpec) {
        Spec specToUpdate = specRepository.findById(id).get();
        specToUpdate.setName(newSpec.getName()!=null ? newSpec.getName() : specToUpdate.getName());
        specToUpdate.setContent(newSpec.getContent()!=null ? newSpec.getContent() : specToUpdate.getContent());
        specRepository.save(specToUpdate);
    }

    // Delete Methods
    public void deleteSpec(Long id) {
        specRepository.deleteById(id);
    }
}
