package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class EventNotification extends DataPacket {

    private byte eventType;	        // event notification type identifier
    private short eventValue;		// event notification value identifier

    public EventNotification() {
    }

    public EventNotification(JsonObject eventNotification) {
        try {
            eventType = eventNotification.get("eventType").getAsByte();
            eventValue = eventNotification.get("value").getAsShort();
        } catch (Exception ex) {
            eventType = -1;
            eventValue = -1;
        }
    }


    @Override
    public String toString() {
        return "EventNotification{" +
                "eventType=" + eventType +
                ", eventValue=" + eventValue +
                '}';
    }
}
