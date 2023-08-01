package com.ergun.news.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "article")
    private String article;
    @Column(name = "region")
    private String region;
    @Column(name = "category")
    private String category;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "image_id",referencedColumnName = "id")
    @JsonIgnore
    private Image image;

    public News(String title, String article, String region, String category) {
        this.title = title;
        this.article = article;
        this.region = region;
        this.category = category;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", region='" + region + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
