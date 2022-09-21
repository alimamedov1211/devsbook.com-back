package com.devsbook.devsbook.service;

import com.devsbook.devsbook.entity.Friend;
import com.devsbook.devsbook.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService {

    FriendRepository friendRepository;

    @Autowired
    public FriendsService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }


    public void createNewFriend(Friend friend) {
        friendRepository.save(friend);
    }

    public Friend updateFriend(Friend friend) {
        int userId = friend.getUserId();
        Friend user = friendRepository.findByUserId(userId);
        user.setFriendRequestsId(friend.getFriendRequestsId());
        user.setFriendsId(friend.getFriendsId());
        user.setMyRequestsId(friend.getMyRequestsId());
        return friendRepository.save(user);
    }

    public Friend getFriend(int userId) {
        return friendRepository.findByUserId(userId);
    }


}
