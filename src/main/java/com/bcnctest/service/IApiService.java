package com.bcnctest.service;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.dto.PhotoDTO;

import java.util.List;

public interface IApiService {
    List<PhotoDTO> loadPhotos();

    List<AlbumDTO> loadAlbums();

}
