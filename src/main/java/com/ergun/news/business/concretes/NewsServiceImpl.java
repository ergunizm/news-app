package com.ergun.news.business.concretes;

import com.ergun.news.business.abstracts.NewsService;
import com.ergun.news.dataAccess.abstracts.ImageRepository;
import com.ergun.news.dataAccess.abstracts.NewsRepository;
import com.ergun.news.entities.News;
import com.ergun.news.utility.ImageUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News addNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    @Transactional
    public News addImageToNews(int newsId, String imageName) {
        News tmp = newsRepository.findById(newsId);
        if(tmp != null){
            tmp.setImage(imageRepository.findByName(imageName).get());
            newsRepository.save(tmp);
        }

        return tmp;
    }

    @Override
    @Transactional
    public byte[] getImageOfNews(int newsId) {
        News tmp = newsRepository.findById(newsId);

        if(tmp!= null && tmp.getImage() != null){
            byte[] image = ImageUtil.decompressImage(tmp.getImage().getData());
            return image;
        }else{
            return null;
        }
    }

    @Override
    public News getNewsById(int id) {
        return newsRepository.findById(id);
    }

    @Override
    public List<News> getNewsByRegion(String region) {
        return newsRepository.findByRegion(region);
    }
    @Override
    public List<News> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category);
    }

    @Override
    public List<News> getNewsByTitle(String title) {
        List<News> returned = new ArrayList<>();
        for(News n : newsRepository.findAll()){
            if(n.getTitle().toLowerCase().contains(title.toLowerCase())){
                returned.add(n);
            }
        }

        return returned;
    }
}
