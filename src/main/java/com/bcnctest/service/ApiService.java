package com.bcnctest.service;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.dto.PhotoDTO;
import com.bcnctest.shared.Constant;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiService implements IApiService {


    public List<PhotoDTO> loadPhotos() {
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(Constant.URL + "/photos")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public List<AlbumDTO> loadAlbums() {
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(Constant.URL + "/albums")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }


}
