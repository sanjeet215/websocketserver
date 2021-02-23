package com.asiczen.websocket.consumer;

import com.asiczen.websocket.model.TripMessage;
import com.asiczen.websocket.service.ProcessTripMessages;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiczen.websocket.model.AlertMessage;
import com.asiczen.websocket.model.TransformedMessage;
import com.asiczen.websocket.service.ProcessAlertMessages;
import com.asiczen.websocket.service.ProcessMessages;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageConsumer {

	@Autowired
	ProcessMessages messageProcessService;
	
	@Autowired
	ProcessAlertMessages alertProcessor;

	@Autowired
	ProcessTripMessages processTripMessages;

	@RabbitListener(queues = "covertedMessagesSocket")
	public void onRecievedMessage(TransformedMessage message) {
		log.trace("Message Read is : {}", message.toString());
		messageProcessService.processMessage(message);

	}
	
	
	@RabbitListener(queues = "alert-messages")
	public void onAlertMessage(AlertMessage message) {
		alertProcessor.sendAlertMessage(message);
	}



	@RabbitListener(queues = "trip-messages")
	public void onTripMessageArrival(TripMessage message) {
		processTripMessages.consumeTripMessages(message);
	}
}
