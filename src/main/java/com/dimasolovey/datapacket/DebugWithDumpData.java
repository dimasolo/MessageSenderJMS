package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class DebugWithDumpData extends DataPacket {

    private short dumpType;
    private byte signature;
    private int pktCnt;
    private int pktTotCnt;
    byte[] dumpData = null;


    public DebugWithDumpData() {
    }

    public DebugWithDumpData(JsonObject debugWithDumpData) {
        try {
            dumpType = debugWithDumpData.get("dumpType").getAsShort();
            signature = debugWithDumpData.get("signature").getAsByte();
            pktCnt = debugWithDumpData.get("pktCnt").getAsInt();
            pktTotCnt = debugWithDumpData.get("pktTotCnt").getAsInt();
            dumpData = debugWithDumpData.get("dumpData").getAsString().getBytes();

        } catch (Exception ex) {
            dumpType = 0;
            signature = 0;
            pktCnt = 0;
            pktTotCnt = 0;
            dumpData = null;
        }
    }

    @Override
    public String toString() {
        return "DebugWithDumpData{" +
                "dumpType=" + dumpType +
                ", signature=" + signature +
                ", pktCnt=" + pktCnt +
                ", pktTotCnt=" + pktTotCnt +
                ", dumpData=" + Arrays.toString(dumpData) +
                '}';
    }
}
