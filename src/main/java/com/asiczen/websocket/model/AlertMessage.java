package com.asiczen.websocket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertMessage {

	private String orgRefName;
	private String vehicleNumber;
	private String driverName;
	private AlertType alertType;
}
