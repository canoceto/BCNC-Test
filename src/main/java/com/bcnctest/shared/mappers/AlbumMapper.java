package com.bcnctest.shared.mappers;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.models.AlbumEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AlbumMapper {
    AlbumDTO mapperAlbumEntityToAlbumDTO(AlbumEntity album);

}
