package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class TransmissionMode extends DataPacket {

    private byte mode;	// OBU transmission mode

    public TransmissionMode() {
    }

    public TransmissionMode(JsonObject transmissionMode) {
        try {
            mode = transmissionMode.get("mode").getAsByte();
        } catch (Exception ex) {
            mode = -1;
        }
    }

    @Override
    public String toString() {
        return "TransmissionMode{" +
                "mode=" + mode +
                '}';
    }
}
