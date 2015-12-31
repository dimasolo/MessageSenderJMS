package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class ESCallNotification extends DataPacket {

    private byte callId; 	// ESCall event identifier
    private byte callType;	// ESCall event type

    public ESCallNotification() {
    }

    public ESCallNotification(JsonObject esCallNotification) {
        try {
            callId = esCallNotification.get("callId").getAsByte();
            callType = esCallNotification.get("callType").getAsByte();
        }catch (Exception ex) {
            callId = -1;
            callType = -1;
        }
    }

    @Override
    public String toString() {
        return "ESCallNotification{" +
                "callId=" + callId +
                ", callType=" + callType +
                '}';
    }
}
