package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class ICCID extends DataPacket {

    private String iccId;

    public ICCID() {
    }

    public ICCID(JsonObject iccid) {
        try {
            iccId = iccid.get("iccId").getAsString();
        } catch (Exception ex) {
            iccId = null;
        }
    }

    @Override
    public String toString() {
        return "ICCID{" +
                "iccId='" + iccId + '\'' +
                '}';
    }
}
