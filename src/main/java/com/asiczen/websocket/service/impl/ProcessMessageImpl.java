package com.asiczen.websocket.service.impl;

import java.math.RoundingMode;
import java.text.SimpleDateFormat;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.asiczen.websocket.model.SocketMessage;
import com.asiczen.websocket.model.TransformedMessage;
import com.asiczen.websocket.service.ProcessMessages;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProcessMessageImpl implements ProcessMessages {

	@Autowired
	SimpMessagingTemplate messageTemplate;

	@Override
	public void processMessage(TransformedMessage message) {

		SocketMessage socketMessage = new SocketMessage();
		BeanUtils.copyProperties(message, socketMessage);

		socketMessage.setImeiNumber(message.getImei());
		socketMessage.setCurrentFlag(true);

		socketMessage.setTopSpeed(message.getTopSpeed().setScale(0, RoundingMode.HALF_EVEN));
		socketMessage.setCalculatedDailyDistance(message.getCalculatedDailyDistance().setScale(2, RoundingMode.HALF_EVEN));
		socketMessage.setAverageSpeed(message.getAverageSpeed().setScale(1, RoundingMode.HALF_EVEN));
		socketMessage.setCalculatedSpeed(message.getCalculatedSpeed().setScale(1, RoundingMode.HALF_EVEN));

		socketMessage.setDateTimestamp(message.getTimestamp());

		this.messageTemplate.convertAndSend("/topic/" + socketMessage.getVehicleNumber(), socketMessage);
		this.messageTemplate.convertAndSend("/topic/" + socketMessage.getOrgRefName(), socketMessage);

	}
}
