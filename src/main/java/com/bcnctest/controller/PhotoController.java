package com.bcnctest.controller;

import com.bcnctest.models.PhotoEntity;
import com.bcnctest.service.IPhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/photo")
public class PhotoController {
    private final IPhotoService photoService;

    public PhotoController(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/load/all")
    public ResponseEntity<List<PhotoEntity>> loadAllPhotos() {
        try {
            return new ResponseEntity<>(photoService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/recover/all")
    public ResponseEntity<List<PhotoEntity>> loadAllPhotosFromAPI() {
        try {
            return new ResponseEntity<>(photoService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PhotoEntity>> getAllPhotosFromH2DB() {
        try {
            return new ResponseEntity<>(photoService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
