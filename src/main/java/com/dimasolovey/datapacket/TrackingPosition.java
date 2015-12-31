package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class TrackingPosition extends DataPacket {

    private boolean trckPosPerTime;	// Tracking position event cause per time interval
    private boolean trckPosPerDist;	// Tracking position event cause per traveled distance interval
    private boolean trckPosPerCourse;	// Tracking position event cause per course (gps heading) variation

    public TrackingPosition() {
    }

    public TrackingPosition(JsonObject trackingPosition) {
        try {
            trckPosPerTime = trackingPosition.get("trckPosPerTime").getAsBoolean();
            trckPosPerDist = trackingPosition.get("trckPosPerDist").getAsBoolean();
            trckPosPerCourse = trackingPosition.get("trckPosPerCourse").getAsBoolean();
        } catch (Exception ex) {
            trckPosPerCourse = false;
            trckPosPerDist = false;
            trckPosPerTime = false;
        }
    }

    @Override
    public String toString() {
        return "TrackingPosition{" +
                "trckPosPerTime=" + trckPosPerTime +
                ", trckPosPerDist=" + trckPosPerDist +
                ", trckPosPerCourse=" + trckPosPerCourse +
                '}';
    }
}
