package com.bcnctest.controller;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController()
@RequestMapping("api/")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {

        this.albumService = albumService;
    }

    @PostMapping(value = "load/all")
    public ResponseEntity<Void> loadAllAlbum() {
        albumService.loadAlbumsWithPhotosIntoDB();
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("api/all")
                                .build()
                                .toUri()
                ).contentType(MediaType.APPLICATION_JSON)
                .build();
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
