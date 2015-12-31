package com.dimasolovey.datapacket;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class AccelerationInfo extends DataPacket{
    private short accelerationX;
    private short accelerationY;
    private short accelerationZ;

    public AccelerationInfo(JsonObject acceleration) {
        try {
            JsonObject jsonObjectAcceleration = acceleration.get("accelerations").getAsJsonObject();
            JsonArray jsonArrayAcceleration = jsonObjectAcceleration.get("data").getAsJsonArray();
            accelerationX = jsonArrayAcceleration.get(0).getAsShort();
            accelerationY = jsonArrayAcceleration.get(1).getAsShort();
            accelerationZ = jsonArrayAcceleration.get(2).getAsShort();
        } catch (Exception ex) {
            accelerationX = 0;
            accelerationY = 0;
            accelerationZ = 0;
        }
    }

    @Override
    public String toString() {
        return "AccelerationInfo{" +
                "accelerationX=" + accelerationX +
                ", accelerationY=" + accelerationY +
                ", accelerationZ=" + accelerationZ +
                '}';
    }
}
