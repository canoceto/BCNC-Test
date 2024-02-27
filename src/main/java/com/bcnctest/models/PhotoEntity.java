package com.bcnctest.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;

@Setter
@Getter
@Entity
@Builder
@Table(name = "photo")
@NoArgsConstructor
@AllArgsConstructor
public class PhotoEntity implements Serializable {
    @Id
    private Long id;
    @Column(name = "albumId", nullable = false)
    private Integer albumId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "thumbnailUrl", nullable = false)
    private String thumbnailUrl;

    @Setter
    @ManyToMany(mappedBy = "photos")
    private Collection<AlbumEntity> albumEntities;

}
