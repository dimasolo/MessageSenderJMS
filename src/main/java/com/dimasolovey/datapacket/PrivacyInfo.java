package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class PrivacyInfo extends DataPacket {

    private long travelDist;	// [km/10] Current traveled distance value for the ongoing privacy session

    public PrivacyInfo() {
    }

    public PrivacyInfo(JsonObject privacyInfo) {
        try {
            travelDist = privacyInfo.get("travelDist").getAsLong();
        } catch(Exception ex) {
            travelDist = 0;
        }
    }

    @Override
    public String toString() {
        return "PrivacyInfo{" +
                "travelDist=" + travelDist +
                '}';
    }
}
