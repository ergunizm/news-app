package com.ergun.news.business.concretes;

import com.ergun.news.business.abstracts.ImageService;
import com.ergun.news.dataAccess.abstracts.ImageRepository;
import com.ergun.news.entities.Image;
import com.ergun.news.utility.ImageUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository repository;

    public void uploadImage(MultipartFile file) throws IOException {
        repository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .data(ImageUtil.compressImage(file.getBytes())).build());

    }

    @Transactional
    public Image getImageInfoByName(String name) {
        Optional<Image> tmp = repository.findByName(name);

        return Image.builder()
                .id(tmp.get().getId())
                .name(tmp.get().getName())
                .type(tmp.get().getType())
                .data(ImageUtil.decompressImage(tmp.get().getData())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<Image> dbImage = repository.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getData());
        return image;
    }
}
