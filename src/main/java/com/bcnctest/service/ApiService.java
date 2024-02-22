package com.bcnctest.service;

import com.bcnctest.dto.AlbumDTO;
import com.bcnctest.dto.PhotoDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiService implements IApiService {
    private final String url = "https://jsonplaceholder.typicode.com";

    public List<PhotoDTO> loadPhotos() {
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(url + "/photos")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public List<AlbumDTO> loadAlbums() {
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(url + "/albums")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }


}
