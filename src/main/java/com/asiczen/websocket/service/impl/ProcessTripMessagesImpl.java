package com.asiczen.websocket.service.impl;

import com.asiczen.websocket.model.TripMessage;
import com.asiczen.websocket.service.ProcessTripMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcessTripMessagesImpl implements ProcessTripMessages {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Override
    public void consumeTripMessages(TripMessage tripMessage) {
        this.messagingTemplate.convertAndSend("/topic/" + tripMessage.getOrgRefName() + "/trips", tripMessage);
        this.messagingTemplate.convertAndSend("/topic/" + tripMessage.getVehicleNumber() + "/trips", tripMessage);
    }
}
