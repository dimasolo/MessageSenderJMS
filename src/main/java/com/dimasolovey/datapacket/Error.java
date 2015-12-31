package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class Error extends DataPacket {

    private short errPktID;	// protocol ID of the Data Packet related to the error
    private short errCode;	// error code identifier

    public Error() {
    }

    public Error(JsonObject error) {
        try {
            errCode = error.get("errCode").getAsShort();
            errPktID = error.get("errPktID").getAsShort();
        } catch(Exception ex) {
            errCode = -1;
            errPktID = -1;
        }
    }

    @Override
    public String toString() {
        return "Error{" +
                "errPktID=" + errPktID +
                ", errCode=" + errCode +
                '}';
    }
}
