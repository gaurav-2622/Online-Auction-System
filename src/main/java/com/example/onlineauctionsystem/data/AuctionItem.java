package com.example.onlineauctionsystem.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double startingPrice;

    @OneToMany(mappedBy = "auctionItem", cascade = CascadeType.ALL)
    private List<Bid> bids;

    private Boolean isActive;
}
