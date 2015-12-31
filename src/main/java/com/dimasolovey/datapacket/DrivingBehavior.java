package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class DrivingBehavior extends  DataPacket {

    private byte axis;		// axis along which the acceleration sample has overridden the level thresholds
    private byte levelMask;	// bitmask including the triggered level thresholds

    public DrivingBehavior() {
    }

    public DrivingBehavior(JsonObject drivingBehavior) {
        try {
            axis = drivingBehavior.get("axis").getAsByte();
            levelMask = drivingBehavior.get("levelMask").getAsByte();
        }catch(Exception ex) {
            axis = -1;
            levelMask = -1;
        }
    }

    @Override
    public String toString() {
        return "DrivingBehavior{" +
                "axis=" + axis +
                ", levelMask=" + levelMask +
                '}';
    }
}
