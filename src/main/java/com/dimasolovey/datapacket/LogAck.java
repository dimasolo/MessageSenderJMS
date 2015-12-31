package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;



/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class LogAck extends DataPacket {

    private byte handle;	// Progressive counter of the log data packet to be acknowledged
    private int size;		// Size of the log data packet to be acknowledged

    public LogAck() {
    }

    public LogAck(JsonObject logAck) {
        try {
            handle = logAck.get("handle").getAsByte();
            size = logAck.get("size").getAsInt();
        } catch (Exception ex) {
            handle = 0;
            size = 0;
        }
    }


    @Override
    public String toString() {
        return "LogAck{" +
                "handle=" + handle +
                ", size=" + size +
                '}';
    }
}
