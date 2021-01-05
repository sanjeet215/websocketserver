package com.asiczen.websocket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.asiczen.websocket.model.AlertMessage;
import com.asiczen.websocket.service.ProcessAlertMessages;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProcessAlertMessagesImpl implements ProcessAlertMessages {

	@Autowired
	SimpMessagingTemplate messageTemplate;

	@Override
	public void sendalertMessage(AlertMessage message) {
		this.messageTemplate.convertAndSend("/topic/" + message.getOrgRefName(), message);
	}

}
