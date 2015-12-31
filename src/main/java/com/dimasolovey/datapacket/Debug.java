package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class Debug extends DataPacket {

    private int dbgCode;
    private int dbgData;

    public Debug() {
    }

    public Debug(JsonObject debug) {
        try {
            dbgCode = debug.get("dbgCode").getAsInt();
            dbgData = debug.get("dbgData").getAsInt();
        } catch (Exception ex) {
            dbgCode = -1;
            dbgData = -1;
        }
    }

    @Override
    public String toString() {
        return "Debug{" +
                "dbgCode=" + dbgCode +
                ", dbgData=" + dbgData +
                '}';
    }
}
