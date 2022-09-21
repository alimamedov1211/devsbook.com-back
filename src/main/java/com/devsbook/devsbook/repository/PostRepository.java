package com.devsbook.devsbook.repository;


import com.devsbook.devsbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    int countPostByUserId(int userId);
    int countPostByUserIdAndPostType(int userId, String type);

}
