package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class DriverId extends DataPacket {


    private byte slotId;			// ID Tag slot number
    private boolean idTagBattLowSt;	// ID Tag Battery status

    public DriverId() {
    }

    public DriverId(JsonObject driverId) {
        try {
            slotId = driverId.get("slotId").getAsByte();
            idTagBattLowSt = driverId.get("idTagBattLowSt").getAsBoolean();
        } catch (Exception ex) {
            slotId = 0;
            idTagBattLowSt = false;
        }
    }

    @Override
    public String toString() {
        return "DriverId{" +
                "slotId=" + slotId +
                ", idTagBattLowSt=" + idTagBattLowSt +
                '}';
    }
}
