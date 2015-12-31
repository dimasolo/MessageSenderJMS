package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class AnalogInfo extends DataPacket {

    private float battExt;
    private float battInt;
    private byte temperature;

    public AnalogInfo() {
    }

    public AnalogInfo(JsonObject analogInfo) {
        try {
            battInt = analogInfo.get("vbattInt").getAsFloat();
            battExt = analogInfo.get("vbattExt").getAsFloat();
            temperature = analogInfo.get("temperature").getAsByte();

        } catch (Exception ex) {
            battExt = 0;
            battInt = 0;
            temperature = 0;
        }
    }

    @Override
    public String toString() {
        return "AnalogInfo{" +
                "battExt=" + battExt +
                ", battInt=" + battInt +
                ", temperature=" + temperature +
                '}';
    }
}
