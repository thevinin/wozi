package com.wozi.adsb.common;

public class Track {
	private long acID;			// aircraft ID - unique number within tracking system
	private double latitude;	// aircraft latitude - ECEF coordinate frame
	private double longitude;	// aircraft longitutde - ECEF coordinate frame	private double altitude;
	private double altitude;
	private double speed;
	private double updateTime;
	
	public Track(long id, double latitude, double longitutde, double altitude, double speed, double time) {
		acID = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.speed = speed;
		this.updateTime = time;
	}
}
