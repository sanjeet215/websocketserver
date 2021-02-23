package com.asiczen.websocket.service.impl;

import com.asiczen.websocket.model.TripMessage;
import com.asiczen.websocket.service.ProcessTripMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class ProcessTripMessagesImpl implements ProcessTripMessages {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Override
    public void consumeTripMessages(TripMessage tripMessage) {
        this.messagingTemplate.convertAndSend("/trip/topic/" + tripMessage.getOrgRefName(), tripMessage);
        this.messagingTemplate.convertAndSend("/trip/topic/" + tripMessage.getVehicleNumber(), tripMessage);
    }
}
