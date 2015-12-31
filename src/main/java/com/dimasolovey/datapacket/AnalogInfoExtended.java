package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class AnalogInfoExtended extends DataPacket {

    private float battExt;
    private float battInt;
    private byte temperature;

    public AnalogInfoExtended() {
    }

    public AnalogInfoExtended(JsonObject analogInfoExtended) {
        try {
            battExt = analogInfoExtended.get("vbattExt").getAsFloat();
            battInt = analogInfoExtended.get("vbattInt").getAsFloat();
            temperature = analogInfoExtended.get("temperature").getAsByte();

        } catch (Exception ex) {
            battExt = 0;
            battInt = 0;
            temperature = 0;
        }
    }

    @Override
    public String toString() {
        return "AnalogInfoExtended{" +
                "battExt=" + battExt +
                ", battInt=" + battInt +
                ", temperature=" + temperature +
                '}';
    }
}
