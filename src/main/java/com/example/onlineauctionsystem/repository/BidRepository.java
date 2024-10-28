package com.example.onlineauctionsystem.repository;

import com.example.onlineauctionsystem.data.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid,Long> {

    List<Bid> findByAuctionItemId(Long auctionItemId);
}
