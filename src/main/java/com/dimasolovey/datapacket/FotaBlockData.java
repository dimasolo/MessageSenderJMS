package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class FotaBlockData extends DataPacket {

    short blockRequested;	// Requested data block number that OBU expects
    byte[] data = null;		// Area containing FW data block
    short offset;			// Real position offset of the requested data block in the FW image
    byte mode;				// Update mode
                            // 		0: block hole blank (0xFFs);
                            // 		1: incremental update (block hole taken from the old firmware version in the correct bank). Not yet implemented.

    public FotaBlockData() {
    }

    public FotaBlockData(JsonObject fotaBlockData) {
        try {
            blockRequested = fotaBlockData.get("blockRequested").getAsShort();
            data = fotaBlockData.get("data").getAsString().getBytes();
            offset = fotaBlockData.get("offset").getAsShort();
            mode = fotaBlockData.get("mode").getAsByte();
        } catch(Exception ex) {
            blockRequested = -1;
            data = null;
            offset = -1;
            mode = -1;
        }
    }

    @Override
    public String toString() {
        return "FotaBlockData{" +
                "blockRequested=" + blockRequested +
                ", data=" + Arrays.toString(data) +
                ", offset=" + offset +
                ", mode=" + mode +
                '}';
    }
}
