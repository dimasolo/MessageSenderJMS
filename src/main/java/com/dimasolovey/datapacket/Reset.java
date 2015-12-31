package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class Reset extends DataPacket {

    private byte device;		// Device identifier
    private byte operation;	    // Mode identifier

    public Reset() {
    }

    public Reset(JsonObject reset) {
        try {
            device = reset.get("device").getAsByte();
            operation = reset.get("operation").getAsByte();
        }catch(Exception ex) {
            device = -1;
            operation = -1;
        }
    }

    @Override
    public String toString() {
        return "Reset{" +
                "device=" + device +
                ", operation=" + operation +
                '}';
    }
}
