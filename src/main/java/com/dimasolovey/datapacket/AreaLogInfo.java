package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class AreaLogInfo extends DataPacket {

    private long areaLogSize;
    private long usedSize;
    private long sentAcked;

    public AreaLogInfo() {
    }

    public AreaLogInfo(JsonObject areaLogInfo) {
        try {
            areaLogSize = areaLogInfo.get("areaLogSize").getAsLong();
            usedSize = areaLogInfo.get("usedSize").getAsLong();
            sentAcked = areaLogInfo.get("sentAcked").getAsLong();
        }catch (Exception ex) {
            areaLogSize = 0;
            usedSize = 0;
            sentAcked = 0;
        }
    }

    @Override
    public String toString() {
        return "AreaLogInfo{" +
                "areaLogSize=" + areaLogSize +
                ", usedSize=" + usedSize +
                ", sentAcked=" + sentAcked +
                '}';
    }
}
