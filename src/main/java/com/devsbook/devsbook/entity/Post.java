package com.devsbook.devsbook.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@Builder
public class Post {


    @Id
    @GeneratedValue
    private int id;


    @Column(nullable = false, unique = false, length = 255)
    private int userId;
    private String postType;

    @Column(nullable = false,unique = false, length = 10485760)
    private String post;

    public Post() {
    }
}
