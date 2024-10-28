package com.example.onlineauctionsystem.controller;

import com.example.onlineauctionsystem.data.AuctionItem;
import com.example.onlineauctionsystem.data.Bid;
import com.example.onlineauctionsystem.repository.AuctionItemRepository;
import com.example.onlineauctionsystem.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    @Autowired
    private BidRepository bidRepository;

    @GetMapping
    public List<AuctionItem> getAllAuctions() {
        return auctionItemRepository.findAll();
    }

    @PostMapping
    public AuctionItem createAuction(@RequestBody AuctionItem auctionItem) {
        return auctionItemRepository.save(auctionItem);
    }

    @PostMapping("/{id}/bid")
    public ResponseEntity<?> placeBid(@PathVariable Long id, @RequestBody Bid bid) {
        AuctionItem item = auctionItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
        bid.setAuctionItem(item);
        bidRepository.save(bid);
        return ResponseEntity.ok().body("Bid placed successfully");
    }
}

