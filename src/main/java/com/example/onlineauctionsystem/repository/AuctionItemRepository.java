package com.example.onlineauctionsystem.repository;

import com.example.onlineauctionsystem.data.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {
}
