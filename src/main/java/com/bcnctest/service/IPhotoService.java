package com.bcnctest.service;

import com.bcnctest.models.PhotoEntity;

import java.util.LinkedList;
import java.util.List;

public interface IPhotoService {
    void create(LinkedList<PhotoEntity> photoEntities);

    LinkedList<PhotoEntity> update(LinkedList<PhotoEntity> photoEntities);

    PhotoEntity delete(PhotoEntity photoEntity);

    LinkedList<PhotoEntity> deleteAll();

    List<PhotoEntity> getAll();
}
