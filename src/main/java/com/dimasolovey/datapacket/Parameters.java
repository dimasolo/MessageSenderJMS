package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class Parameters extends DataPacket {

    private short paramId;	// parameter identifier
    private short offset;		// parameter relative starting byte offset
    private short size;		// parameter relative interested byte size (from starting byte offset)
    private boolean dimCheck; // size check option status
    private byte[] values;

    public Parameters() {
    }

    public Parameters(JsonObject parameters) {
        try {
            paramId = parameters.get("paramId").getAsShort();
            offset = parameters.get("offset").getAsShort();
            size = parameters.get("size").getAsShort();
            dimCheck = parameters.get("dimCheck").getAsBoolean();
            values = parameters.get("values").getAsString().getBytes();
        } catch (Exception ex) {
            paramId = 0;
            offset = 0;
            size = 0;
            dimCheck = false;
            values = null;
        }
    }


    @Override
    public String toString() {
        return "Parameters{" +
                "paramId=" + paramId +
                ", offset=" + offset +
                ", size=" + size +
                ", dimCheck=" + dimCheck +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
