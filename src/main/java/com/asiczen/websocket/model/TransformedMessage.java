package com.asiczen.websocket.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransformedMessage {

	// Original Fields
	private String imei;
	private int gps;
	private BigDecimal lat;
	private BigDecimal lng;
	private boolean isKeyOn;
	private int heading;
	private Date timestamp;
	private int unplugged;
	private int fuel;
	private int speed;

	// Derived Fields
	private String vehicleNumber;
	private String vehicleType;
	private String driverName;
	private String driverContact;
	private String orgRefName;

	private BigDecimal calculatedSpeed = new BigDecimal("0");
	private BigDecimal averageSpeed = new BigDecimal("0");
	private BigDecimal calulatedDistance = new BigDecimal("0");
	private BigDecimal calculatedDailyDistance = new BigDecimal("0");
	private BigDecimal topSpeed = new BigDecimal("0");

	// Seconds
	private int idleKeyOnTime; // Vehicle Key is on but vehicle is not moving
	private int idleKeyOffTime; // Key is off and Vehicle is not moving
	private int vehicleMovingTime; // key is on and vehicle is moving

	// Tank
	private BigDecimal currentFuel = new BigDecimal("0");

	// Flags for Different status
	boolean idleEngineOn;
	boolean idleEngineOff;
	boolean vehicleMovingFlag;
	boolean alertFlag;
	boolean currentFlag;
	boolean geoViolation;
	boolean speedViolation;
	boolean delayedMessageFlag;

	// Total Number of Messages
	int messageCounter;
}
