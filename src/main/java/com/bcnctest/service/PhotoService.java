package com.bcnctest.service;

import com.bcnctest.models.PhotoEntity;
import com.bcnctest.repository.IPhotoRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PhotoService implements IPhotoService {
    private final IPhotoRepository photoRepository;

    public PhotoService(IPhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    @Override
    public void create(LinkedList<PhotoEntity> photoEntities) {
        photoRepository.saveAll(photoEntities);
    }

    @Override
    public LinkedList<PhotoEntity> update(LinkedList<PhotoEntity> photoEntities) {
        return new LinkedList<>();
    }

    @Override
    public PhotoEntity delete(PhotoEntity photoEntity) {
        return null;
    }

    @Override
    public LinkedList<PhotoEntity> deleteAll() {
        return new LinkedList<>();
    }

    @Override
    public List<PhotoEntity> getAll() {
        return (List<PhotoEntity>) photoRepository.findAll();
    }

}
