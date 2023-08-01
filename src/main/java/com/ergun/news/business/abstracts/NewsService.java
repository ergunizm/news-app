package com.ergun.news.business.abstracts;

import com.ergun.news.entities.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    News addNews(News news);
    News addImageToNews(int newsId, String imageName);
    byte[] getImageOfNews(int newsId);
    News getNewsById(int id);
    List<News> getNewsByRegion(String region);
    List<News> getNewsByCategory(String region);
    List<News> getNewsByTitle(String title);
}
