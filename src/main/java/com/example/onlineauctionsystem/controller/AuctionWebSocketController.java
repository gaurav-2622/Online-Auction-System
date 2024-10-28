package com.example.onlineauctionsystem.controller;

import com.example.onlineauctionsystem.data.Bid;
import com.example.onlineauctionsystem.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class AuctionWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private BidRepository bidRepository;
    @MessageMapping("/bid")
    @SendTo("/topic/bids")
    public Bid placeBid(Bid bid) {
        // Save the bid and broadcast the updated bid
        Bid savedBid = bidRepository.save(bid);
        messagingTemplate.convertAndSend("/topic/bids", savedBid);
        return savedBid;
    }
}
