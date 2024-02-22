package com.bcnctest.repository;

import com.bcnctest.models.AlbumEntity;
import org.springframework.data.repository.CrudRepository;


public interface IAlbumRepository extends CrudRepository<AlbumEntity, Integer> {

}
