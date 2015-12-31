package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class Flash extends DataPacket {

    private byte devOperation;	// Flash device operation

    public Flash() {
    }

    public Flash(JsonObject flash) {
        try {
            devOperation = flash.get("devOperation").getAsByte();
        }catch (Exception ex) {
            devOperation = -1;
        }
    }

    @Override
    public String toString() {
        return "Flash{" +
                "devOperation=" + devOperation +
                '}';
    }
}
