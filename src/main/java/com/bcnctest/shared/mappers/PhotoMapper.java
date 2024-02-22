package com.bcnctest.shared.mappers;

import com.bcnctest.dto.PhotoDTO;
import com.bcnctest.models.PhotoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PhotoMapper {
    PhotoEntity mapperPhotoDTOtoPhotoEntity(PhotoDTO album);

}
