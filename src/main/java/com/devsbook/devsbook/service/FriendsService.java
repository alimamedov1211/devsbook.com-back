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


    public void friendRequest(int userId, int requestId) {
        Friend friend = friendRepository.findByUserId(userId);
        String myRequestId = friend.getMyRequestsId();
        if (myRequestId == null) {
            myRequestId = "" + requestId;
        } else
            myRequestId += "," + requestId;
        friend.setMyRequestsId(myRequestId);
        friendRepository.save(friend);
    }


    public void createNewFriend(Friend friend) {
        friendRepository.save(friend);
    }


}
