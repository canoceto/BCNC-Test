package com.bcnctest.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
public class PhotoEntity {
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

}
