package com.ergun.news.dataAccess.abstracts;

import com.ergun.news.entities.News;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Integer> {
    News findById(int id);
    List<News> findByRegion(String region);
    List<News> findByCategory(String category);
}
