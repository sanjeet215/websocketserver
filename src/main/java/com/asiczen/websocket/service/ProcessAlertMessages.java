package com.asiczen.websocket.service;

import org.springframework.stereotype.Service;

import com.asiczen.websocket.model.AlertMessage;

@Service
public interface ProcessAlertMessages {

	public void sendalertMessage(AlertMessage message);
}
