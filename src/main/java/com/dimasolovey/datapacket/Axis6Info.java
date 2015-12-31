package com.dimasolovey.datapacket;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class Axis6Info extends DataPacket {

    private short accelerationX;
    private short accelerationY;
    private short accelerationZ;
    private short gyroX;
    private short gyroY;
    private short gyroZ;
    private byte counter;
    private int RTCTime;

    public Axis6Info() {
    }

    public Axis6Info(JsonObject axis6Info) {
        try {
            JsonObject gyro = axis6Info.get("gyro").getAsJsonObject();
            JsonArray gyroData = gyro.get("data").getAsJsonArray();
            gyroX = gyroData.get(0).getAsShort();
            gyroY = gyroData.get(1).getAsShort();
            gyroZ = gyroData.get(2).getAsShort();
            JsonObject accelerations = axis6Info.get("accelerations").getAsJsonObject();
            JsonArray accelerationsData = accelerations.get("data").getAsJsonArray();
            accelerationX = accelerationsData.get(0).getAsShort();
            accelerationY = accelerationsData.get(1).getAsShort();
            accelerationZ = accelerationsData.get(2).getAsShort();
            counter = axis6Info.get("counter").getAsByte();
            RTCTime = axis6Info.get("rtctime").getAsInt();
        } catch (Exception ex) {
            accelerationX = 0;
            accelerationY = 0;
            accelerationZ = 0;
            gyroX = 0;
            gyroY = 0;
            gyroZ = 0;
            counter = 0;
            RTCTime = 0;
        }

    }

    @Override
    public String toString() {
        return "Axis6Info{" +
                "accelerationX=" + accelerationX +
                ", accelerationY=" + accelerationY +
                ", accelerationZ=" + accelerationZ +
                ", gyroX=" + gyroX +
                ", gyroY=" + gyroY +
                ", gyroZ=" + gyroZ +
                ", counter=" + counter +
                ", RTCTime=" + RTCTime +
                '}';
    }
}
