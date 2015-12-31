package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class PositionWithDOP extends Position {

    private byte PDOP;	// GPS/GLONASS Position Dilution Of Precision
    private byte HDOP;	// GPS/GLONASS Horizontal Dilution Of Precision
    private byte VDOP;	// GPS/GLONASS Vertical Dilution Of Precision

    public PositionWithDOP() {
    }

    public PositionWithDOP(JsonObject positionWithDOP) {
        try {
            latitude = positionWithDOP.get("latitude").getAsFloat();
            longitude = positionWithDOP.get("longitude").getAsFloat();
            altitude = positionWithDOP.get("altitude").getAsShort();
            speed = positionWithDOP.get("speed").getAsShort();
            course = positionWithDOP.get("course").getAsShort();
            gpsNumSatellite = positionWithDOP.get("gpsNumSatellite").getAsByte();
            glonassNumSatellite = positionWithDOP.get("glonassNumSatellite").getAsByte();
            fixValid = positionWithDOP.get("fixValid").getAsBoolean();
            timeValid = positionWithDOP.get("timeValid").getAsBoolean();
            wgs84degMinFormat = positionWithDOP.get("wgs84degMinFormat").getAsBoolean();
            glonass = positionWithDOP.get("glonass").getAsBoolean();
            fixMode = positionWithDOP.get("fixMode").getAsByte();
            JsonObject timestamp = positionWithDOP.get("timestamp").getAsJsonObject();
            this.timestamp = timestamp.get("time").getAsLong();
            PDOP = positionWithDOP.get("pdop").getAsByte();
            HDOP = positionWithDOP.get("hdop").getAsByte();
            VDOP = positionWithDOP.get("vdop").getAsByte();

        }catch(Exception ex) {
            latitude = 0;
            longitude = 0;
            altitude = 0;
            speed = -1;
            course = -1;
            gpsNumSatellite = 0;
            glonassNumSatellite = 0;
            fixValid = false;
            timeValid = false;
            wgs84degMinFormat = false;
            glonass = false;
            fixMode = 0;
            timestamp = 0L;
            PDOP = 0;
            HDOP = 0;
            VDOP = 0;
        }
    }

    @Override
    public String toString() {
        return "PositionWithDOP{" +
                "PDOP=" + PDOP +
                ", HDOP=" + HDOP +
                ", VDOP=" + VDOP +
                "} " + super.toString();
    }
}
