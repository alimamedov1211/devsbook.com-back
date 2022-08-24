package com.devsbook.devsbook.repository;

import com.devsbook.devsbook.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    Friend findByUserId(int userId);

}
