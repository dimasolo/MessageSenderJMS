package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CellInfo extends DataPacket {

    private short lac;
    private short cellID;

    public CellInfo() {
    }

    public CellInfo(JsonObject cellInfo) {
        try {
            lac = cellInfo.get("lac").getAsShort();
            cellID = cellInfo.get("cellID").getAsShort();
        } catch (Exception ex) {
            lac = 0;
            cellID = 0;
        }
    }

    @Override
    public String toString() {
        return "CellInfo{" +
                "lac=" + lac +
                ", cellID=" + cellID +
                '}';
    }
}
