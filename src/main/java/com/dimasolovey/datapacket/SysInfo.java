package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class SysInfo extends DataPacket {

    private byte spare;	// spare field value

    public SysInfo() {
    }

    public SysInfo(JsonObject sysInfo) {
        try {
            spare = sysInfo.get("spare").getAsByte();
        } catch (Exception ex) {
            spare = -1;
        }
    }

    @Override
    public String toString() {
        return "SysInfo{" +
                "spare=" + spare +
                '}';
    }
}
