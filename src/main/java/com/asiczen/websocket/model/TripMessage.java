package com.asiczen.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TripMessage {
    private String vehicleNumber;
    private String orgRefName;
    private double totalDistance;
    private double travelDistance;
    private double lat;
    private double lng;
    private boolean isDelayed; // if true then there is a delay
    private boolean isStartLocationSame; // If start location same then true else false
    private int distanceTravelledInPercentage;
    private boolean isDeviated;
}
