package com.ergun.news.business.abstracts;

import com.ergun.news.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    void uploadImage(MultipartFile file) throws IOException;
    Image getImageInfoByName(String name);
    byte[] getImage(String name);
}
