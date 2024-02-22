package com.bcnctest.service;

import com.bcnctest.dto.AlbumDTO;

import java.util.List;

public interface IAlbumService {
    void loadAlbumsWithPhotosIntoDB();

    List<AlbumDTO> returnAlbumsWithPhotos();

    List<AlbumDTO> loadAlbumsWithPhotosWithRedis();

    List<AlbumDTO> loadAlbumsWithPhotosFromDB();

}
