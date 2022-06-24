package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.Picture;
import com.superjahiz.api.domain.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    // Post Methods
    @RequestMapping("/add")
    public void addPicture(@RequestBody Picture picture) {
        pictureService.addPicture(picture);
    }

    // Get Methods
    @RequestMapping("/all")
    public List<Picture> getAllPictures() {
        return pictureService.getAllPictures();
    }
    @RequestMapping("/{id}")
    public Picture getPictureById(@PathVariable("id") long id) {
        return pictureService.getPictureById(id);
    }

    // Put Methods
    @RequestMapping("/edit/{id}")
    public void updatePicture(@PathVariable("id") long id, @RequestBody Picture newPicture) {
        pictureService.updatePicture(id, newPicture);
    }

    // Delete Methods
    @RequestMapping("/delete/{id}")
    public void deletePicture(@PathVariable("id") long id) {
        pictureService.deletePicture(id);
    }

}
