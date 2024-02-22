package com.bcnctest.repository;

import com.bcnctest.models.PhotoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface IPhotoRepository extends CrudRepository<PhotoEntity, Integer> {
    Optional<PhotoEntity> findAllByAlbumId(Integer AlbumId);

    Optional<PhotoEntity> findByAlbumId(Integer id);
}
