package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class WiMetaConfiguration extends DataPacket {

    private byte slotID;	// RF slot ID identifier, referring to the parameter area mapping
    private long rfID;	// RF device identifier
    private byte operationOrStatus;	// Operation or Status type

    public WiMetaConfiguration() {
    }

    public WiMetaConfiguration(JsonObject wiMetaConfiguration) {
        try {
            slotID = wiMetaConfiguration.get("slotID").getAsByte();
            rfID = wiMetaConfiguration.get("rfID").getAsLong();
            operationOrStatus = wiMetaConfiguration.get("operStat").getAsByte();
        } catch (Exception ex) {
            slotID = -1;
            rfID = -1;
            operationOrStatus = -1;
        }
    }

    @Override
    public String toString() {
        return "WiMetaConfiguration{" +
                "slotID=" + slotID +
                ", rfID=" + rfID +
                ", operationOrStatus=" + operationOrStatus +
                '}';
    }
}
