package com.bcnctest.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDTO implements Serializable {

    private Long id;

    private Integer albumId;

    private String title;

    private String url;

    private String thumbnailUrl;

}
