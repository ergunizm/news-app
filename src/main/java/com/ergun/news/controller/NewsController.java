package com.ergun.news.controller;

import com.ergun.news.business.abstracts.NewsService;
import com.ergun.news.entities.News;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/news")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {
    @Autowired
    private NewsService service;

    @GetMapping()
    public List<News> getAll(){
        return service.getAllNews();
    }

    @PostMapping()
    public News addNews(@RequestBody News news) {
        return service.addNews(news);
    }
    @PostMapping("/{newsId}")
    public News addImage(@PathVariable int newsId, @RequestBody String imageName) {
        return service.addImageToNews(newsId, imageName);
    }

    @GetMapping("/img/{newsId}")
    public ResponseEntity<?> getImage(@PathVariable int newsId) {
        byte[] image = service.getImageOfNews(newsId);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable int id){
        return service.getNewsById(id);
    }

    @GetMapping("/region={region}")
    public List<News> getByRegion(@PathVariable String region){
        return service.getNewsByRegion(region);
    }

    @GetMapping("/category={category}")
    public List<News> getByCategory(@PathVariable String category){
        return service.getNewsByCategory(category);
    }

    @GetMapping("/title={title}")
    public List<News> getByTitle(@PathVariable String title){
        return service.getNewsByTitle(title);
    }
}
