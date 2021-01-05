package com.asiczen.websocket.service;

import org.springframework.stereotype.Service;

import com.asiczen.websocket.model.TransformedMessage;

@Service
public interface ProcessMessages {

	public void processMessage(TransformedMessage message);
}
