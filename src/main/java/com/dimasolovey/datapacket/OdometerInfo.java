package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class OdometerInfo extends DataPacket {

    private long odometer; // [m] total traveled distance

    public OdometerInfo() {
    }

    public OdometerInfo(JsonObject odometerInfo) {
        try {
            odometer = odometerInfo.get("odometer").getAsLong();
        } catch(Exception ex) {
            odometer = 0;
        }
    }

    @Override
    public String toString() {
        return "OdometerInfo{" +
                "odometer=" + odometer +
                '}';
    }
}
