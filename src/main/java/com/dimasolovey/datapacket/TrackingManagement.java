package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;


/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class TrackingManagement extends DataPacket {

    private byte status;		// Tracking status
    private byte bearer;		// Tracking communication bearer
    private long time;		    // [s] Time interval for sending positions (this cause restart the calculation of the distance). If value is set to zero, tracking by time will be disabled. Minimum acceptance value is 30 seconds.
    private long distance;	    // [m*10] Traveled distance interval for sending the positions (this cause, reset the timeout). If value is set to zero, tracking by distance will be disabled. Minimum acceptance value is 5 (50 meters).

    public TrackingManagement() {
    }

    public TrackingManagement(JsonObject trackingManagement) {
        try {
            status = trackingManagement.get("status").getAsByte();
            bearer = trackingManagement.get("bearer").getAsByte();
            time = trackingManagement.get("time").getAsLong();
            distance = trackingManagement.get("distance").getAsLong();
        } catch (Exception ex) {
            status = -1;
            bearer = -1;
            time = -1;
            distance = -1;
        }
    }

    @Override
    public String toString() {
        return "TrackingManagement{" +
                "status=" + status +
                ", bearer=" + bearer +
                ", time=" + time +
                ", distance=" + distance +
                '}';
    }
}
