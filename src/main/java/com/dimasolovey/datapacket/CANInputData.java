package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CANInputData extends DataPacket {

    private byte canMessageType;
    private short size;
    private String data = null;

    public CANInputData() {
    }

    public CANInputData(JsonObject canInputData) {
        try {
            canMessageType = canInputData.get("canMessageType").getAsByte();
            size = canInputData.get("size").getAsShort();
            data = canInputData.get("data").getAsString();
        } catch (Exception ex) {
            canMessageType = -1;
            size = 0;
            data = "";
        }
    }

    @Override
    public String toString() {
        return "CANInputData{" +
                "canMessageType=" + canMessageType +
                ", size=" + size +
                ", data='" + data + '\'' +
                '}';
    }
}
