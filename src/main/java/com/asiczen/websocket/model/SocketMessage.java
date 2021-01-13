package com.asiczen.websocket.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocketMessage {

	private String imeiNumber; // Change in field
	private BigDecimal lat;
	private BigDecimal lng;
	private int heading;
	private int fuel;
	
	private String vehicleNumber;
	private String vehicleType;
	private String driverName;
	private String driverContact;
	private String orgRefName;
	
	
	private BigDecimal calculatedSpeed = new BigDecimal("0");
	private BigDecimal averageSpeed = new BigDecimal("0");
	private BigDecimal calculatedDailyDistance = new BigDecimal("0");
	private BigDecimal topSpeed = new BigDecimal("0");
	
	
	private boolean idleEngineOn;
	private boolean idleEngineOff;
	private boolean vehicleMovingFlag;
	private boolean alertFlag;
	private boolean currentFlag;
	private boolean delayedMessageFlag;
	private Date dateTimestamp;
}
