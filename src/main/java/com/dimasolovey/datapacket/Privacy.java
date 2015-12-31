package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class Privacy extends DataPacket {

    private byte level;	// OBU privacy level

    public Privacy() {
    }

    public Privacy(JsonObject privacy) {
        try {
            level = privacy.get("level").getAsByte();
        } catch(Exception ex) {
            level = -1;
        }
    }

    @Override
    public String toString() {
        return "Privacy{" +
                "level=" + level +
                '}';
    }
}
