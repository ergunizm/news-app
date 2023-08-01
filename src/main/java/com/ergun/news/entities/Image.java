package com.ergun.news.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @JdbcType(VarbinaryJdbcType.class)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "data", length = 1000)
    private byte[] data;

    @OneToOne(mappedBy = "image")
    private News news;
}
