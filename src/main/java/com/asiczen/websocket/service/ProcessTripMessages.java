package com.asiczen.websocket.service;

import com.asiczen.websocket.model.TripMessage;
import org.springframework.stereotype.Service;

@Service
public interface ProcessTripMessages {

    public void consumeTripMessages(TripMessage tripMessage);
}
