package com.giantlink.grh.services;

import com.giantlink.grh.dto.response.CompanyImageResponse;
import com.giantlink.grh.entities.CompanyImage;
import com.giantlink.grh.repositories.CompanyImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface CompanyImageService {

    CompanyImageResponse saveDb(MultipartFile image, Integer id) throws IOException;
    CompanyImageResponse saveLocal(MultipartFile image, Integer id) throws IOException;
    CompanyImage getImage(String imageId);

    void initPath();
    public Path getUploadPath();
}
