package com.ergun.news.controller;

import com.ergun.news.business.abstracts.ImageService;
import com.ergun.news.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/img")
public class ImageController {
    @Autowired
    private ImageService service;

    @PostMapping()
    public void uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        service.uploadImage(file);
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<?> getImageInfo(@PathVariable("name") String name){
        Image image = service.getImageInfoByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?>  getImage(@PathVariable("name") String name){
        byte[] image = service.getImage(name);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}
