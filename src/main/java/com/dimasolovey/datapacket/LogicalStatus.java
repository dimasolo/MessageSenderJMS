package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class LogicalStatus extends DataPacket {

    private int logicalStatus;	// logical status bitmask

    public LogicalStatus() {
    }

    public LogicalStatus(JsonObject logicalStatus) {
        try {
            this.logicalStatus = logicalStatus.get("logicalStatus").getAsInt();
        } catch(Exception ex) {
            this.logicalStatus = 0;
        }
    }

    @Override
    public String toString() {
        return "LogicalStatus{" +
                "logicalStatus=" + logicalStatus +
                '}';
    }
}
