package com.devsbook.devsbook.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(nullable = false, unique = false, length = 255)
    private String name;
    private String surname;
    private String password;
    private LocalDateTime createTime;



    @Column(nullable = true,unique = false, length = 10485760)
    private String ProfilePhoto;

    @Column(nullable = false, unique = true, length = 255)
    private String email;
    private String token;


    public User() {
    }


}
