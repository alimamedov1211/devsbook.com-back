package com.devsbook.devsbook.service;


import com.devsbook.devsbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Value("${post.type.image}")
    private String postType;


    PostRepository postRepository;

    @Autowired
    public PostsService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public int countPost(int userId) {
        return postRepository.countPostByUserId(userId);
    }

    public int countPostImage(int userId) {
        return postRepository.countPostByUserIdAndPostType(userId, postType);
    }

}
