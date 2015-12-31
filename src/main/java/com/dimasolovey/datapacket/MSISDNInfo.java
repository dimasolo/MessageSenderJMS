package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class MSISDNInfo extends DataPacket {

    private short numberType;	// numbering scheme
    private short size;			// number of characters of MSISDN information string
    private String MSISDN;		// ASCII string representing MSISDN information

    public MSISDNInfo() {
    }

    public MSISDNInfo(JsonObject msisdnInfo) {
        try {
            numberType = msisdnInfo.get("numberType").getAsShort();
            size = msisdnInfo.get("size").getAsShort();
            MSISDN = msisdnInfo.get("msisdn").getAsString();
        } catch(Exception ex) {
            numberType = 0;
            size = 0;
            MSISDN = "";
        }
    }

    @Override
    public String toString() {
        return "MSISDNInfo{" +
                "numberType=" + numberType +
                ", size=" + size +
                ", MSISDN='" + MSISDN + '\'' +
                '}';
    }
}
