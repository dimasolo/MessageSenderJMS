package com.dimasolovey.datapacket;

import com.dimasolovey.utilites.Timestamp;
import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class Position extends DataPacket {

    protected float latitude;
    protected float longitude;
    protected short altitude;
    protected short speed;
    protected short course;
    protected byte gpsNumSatellite;
    protected byte glonassNumSatellite;
    protected boolean fixValid;
    protected boolean timeValid;
    protected boolean wgs84degMinFormat;
    protected boolean glonass;
    protected byte fixMode;
    protected long timestamp;

    public Position() {
    }

    public Position(JsonObject position) {
        try {
            latitude = position.get("latitude").getAsFloat();
            longitude = position.get("longitude").getAsFloat();
            altitude = position.get("altitude").getAsShort();
            speed = position.get("speed").getAsShort();
            course = position.get("course").getAsShort();
            gpsNumSatellite = position.get("gpsNumSatellite").getAsByte();
            glonassNumSatellite = position.get("glonassNumSatellite").getAsByte();
            fixValid = position.get("fixValid").getAsBoolean();
            timeValid = position.get("timeValid").getAsBoolean();
            wgs84degMinFormat = position.get("wgs84degMinFormat").getAsBoolean();
            glonass = position.get("glonass").getAsBoolean();
            fixMode = position.get("fixMode").getAsByte();
            JsonObject timestamp = position.get("timestamp").getAsJsonObject();
            this.timestamp = timestamp.get("time").getAsLong();
        } catch(Exception ex) {
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
        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", course=" + course +
                ", gpsNumSatellite=" + gpsNumSatellite +
                ", glonassNumSatellite=" + glonassNumSatellite +
                ", fixValid=" + fixValid +
                ", timeValid=" + timeValid +
                ", wgs84degMinFormat=" + wgs84degMinFormat +
                ", glonass=" + glonass +
                ", fixMode=" + fixMode +
                ", timestamp=" + timestamp +
                '}';
    }
}
