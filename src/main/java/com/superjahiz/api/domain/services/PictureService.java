package com.superjahiz.api.domain.services;

import com.superjahiz.api.domain.entities.Picture;
import com.superjahiz.api.domain.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    // Post Methods
    public void addPicture(Picture picture) {
        pictureRepository.save(picture);
    }

    // Get Methods
    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }
    public Picture getPictureById(long id) {
        return pictureRepository.findById(id).get();
    }

    // Put Methods
    public void updatePicture(long id, Picture newPicture) {
        Picture pictureToUpdate = pictureRepository.findById(id).get();
        pictureToUpdate.setUrl(newPicture.getUrl()!=null ? newPicture.getUrl() : pictureToUpdate.getUrl());
        pictureRepository.save(pictureToUpdate);
    }

    // Delete Methods
    public void deletePicture(long id) {
        pictureRepository.deleteById(id);
    }
}
