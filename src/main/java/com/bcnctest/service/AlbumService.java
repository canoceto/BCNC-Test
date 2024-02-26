package com.bcnctest.service;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.dto.PhotoDTO;
import com.bcnctest.exception.NoAlbumException;
import com.bcnctest.models.AlbumEntity;
import com.bcnctest.models.PhotoEntity;
import com.bcnctest.repository.IAlbumRepository;
import com.bcnctest.shared.Constant;
import com.bcnctest.shared.mappers.AlbumMapper;
import com.bcnctest.shared.mappers.PhotoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@EnableCaching
public class AlbumService implements IAlbumService {
    final IAlbumRepository albumRepository;
    private final ApiService apiService;
    private final AlbumMapper albumMapper;
    private final PhotoMapper photoMapper;

    public AlbumService(ApiService apiService, IAlbumRepository albumRepository, AlbumMapper albumMapper, PhotoMapper photoMapper) {
        this.apiService = apiService;
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
        this.photoMapper = photoMapper;
    }

    @Override
    public void loadAlbumsWithPhotosIntoDB() {
        List<AlbumDTO> albumList = apiService.loadAlbums();
        List<PhotoDTO> photosList = apiService.loadPhotos();
        if (albumList.isEmpty()) {
            throw new NoAlbumException("No albums available", Constant.ERROR_404);
        }
        Map<Integer, List<PhotoEntity>> photosMap = photosList
                .stream()
                .map(photoMapper::mapperPhotoDTOtoPhotoEntity)
                .collect(groupingBy(PhotoEntity::getAlbumId));

        List<AlbumEntity> albumEntityList = albumList
                .stream()
                .map(albumDTO -> AlbumEntity
                        .builder()
                        .id(albumDTO.getId())
                        .userId(albumDTO.getUserId())
                        .title(albumDTO.getTitle())
                        .photos(photosMap.get(albumDTO.getId()))
                        .build())

                .toList();
        albumRepository.saveAll(albumEntityList);
    }

    @Override
    public List<AlbumDTO> returnAlbumsWithPhotos() {
        return loadAlbumsFromApi();
    }

    @Override
    public List<AlbumDTO> loadAlbumsWithPhotosFromDB() {
        return ((List<AlbumEntity>) albumRepository.findAll())
                .stream()
                .map(albumMapper::mapperAlbumEntityToAlbumDTO)
                .toList();
    }

    private List<AlbumDTO> loadAlbumsFromApi() {
        List<AlbumDTO> albumList = apiService.loadAlbums();
        List<PhotoDTO> photosList = apiService.loadPhotos();
        if (albumList.isEmpty()) {
            throw new NoAlbumException("No albums available", Constant.ERROR_404);
        }
        Map<Integer, List<PhotoDTO>> photosMap = photosList
                .stream()
                .collect(groupingBy(PhotoDTO::getAlbumId));

        return albumList
                .stream()
                .peek(album -> album.setPhotos(photosMap.get(album.getId())))
                .toList();
    }
}