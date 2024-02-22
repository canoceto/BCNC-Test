package com.bcnctest.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@Builder
@Entity
@Table(name = "Album")
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity {
    @Id
    private Integer id;
    private Integer userId;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = PhotoEntity.class, cascade = CascadeType.ALL)
    @JoinTable(name = "albums_photos", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
    private List<PhotoEntity> photos;


}