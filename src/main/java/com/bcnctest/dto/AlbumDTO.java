package com.bcnctest.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO implements Serializable {
    private Integer id;
    private Integer userId;
    private String title;
    private List<PhotoDTO> photos;

}
