package com.example.onlineauctionsystem.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String username;
    private  String password;

    @OneToMany(mappedBy = "user")
    private List<Bid> bids;
}

