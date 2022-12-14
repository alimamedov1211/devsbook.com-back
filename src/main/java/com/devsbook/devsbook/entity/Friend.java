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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, unique = true, length = 255)
    private int userId;

    @Column(nullable = true,unique = false, length = 10485760)
    private String friendsId;
    private String friendRequestsId;
    private String myRequestsId;

    public Friend() {
    }
}
