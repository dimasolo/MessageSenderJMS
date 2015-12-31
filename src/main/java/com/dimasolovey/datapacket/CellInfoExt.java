package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CellInfoExt extends DataPacket {

    private short lac;
    private short cellID;
    private byte csq;
    private byte regStatus;
    private byte networkCode;

    public CellInfoExt() {
    }

    public CellInfoExt(JsonObject cellInfoExt) {
        try {
            lac = cellInfoExt.get("lac").getAsShort();
            cellID = cellInfoExt.get("cellID").getAsShort();
            csq = cellInfoExt.get("csq").getAsByte();
            regStatus = cellInfoExt.get("regStatus").getAsByte();
            networkCode = cellInfoExt.get("networkCode").getAsByte();
        }catch (Exception ex) {
            lac = 0;
            cellID = 0;
            csq = 0;
            regStatus = 0;
            networkCode = 0;
        }
    }

    @Override
    public String toString() {
        return "CellInfoExt{" +
                "lac=" + lac +
                ", cellID=" + cellID +
                ", csq=" + csq +
                ", regStatus=" + regStatus +
                ", networkCode=" + networkCode +
                '}';
    }
}
