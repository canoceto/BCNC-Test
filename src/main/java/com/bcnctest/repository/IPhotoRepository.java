package com.bcnctest.repository;

import com.bcnctest.models.PhotoEntity;
import org.springframework.data.repository.CrudRepository;


public interface IPhotoRepository extends CrudRepository<PhotoEntity, Integer> {

}
