package com.bcnctest.controller;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {

        this.albumService = albumService;
    }

    @GetMapping("load/all")
    public ResponseEntity<Object> loadAllAlbum() {
        albumService.loadAlbumsWithPhotosIntoDB();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("recover/all")
    public ResponseEntity<List<AlbumDTO>> loadAllAlbumFromAPI() {
        List<AlbumDTO> albums = albumService.returnAlbumsWithPhotos();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<AlbumDTO>> getAllAlbumFromH2DB() {
        List<AlbumDTO> albums = albumService.loadAlbumsWithPhotosFromDB();
        return new ResponseEntity<>(albums, HttpStatus.OK);

    }
}
