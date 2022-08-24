package com.devsbook.devsbook.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "friends")
@Data
@AllArgsConstructor
@Builder
public class Friend {


    @Id
    @GeneratedValue
    private int id;


    @Column(nullable = false, unique = false, length = 255)
    private int userId;

    @Column(nullable = true,unique = false, length = 10485760)
    private String friendsId;
    private String friendRequestsId;

    public Friend() {
    }
}
