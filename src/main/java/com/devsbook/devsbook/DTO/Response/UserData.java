package com.devsbook.devsbook.DTO.Response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {

    private int PostsCount;
    private int FriendsCount;
    private int PhotosCount;


}
