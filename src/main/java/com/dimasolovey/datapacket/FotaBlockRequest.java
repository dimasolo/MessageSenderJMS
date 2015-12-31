package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class FotaBlockRequest extends DataPacket {

    private short blockRequested = 0;	// Requested data block number that OBU expects
    private byte bank = 0;				// Bank of FW image {0, 1}

    public FotaBlockRequest() {
    }

    public FotaBlockRequest(JsonObject fotaBlockRequest) {
        try {
            blockRequested = fotaBlockRequest.get("blockRequested").getAsShort();
            bank = fotaBlockRequest.get("bank").getAsByte();
        } catch (Exception ex) {
            blockRequested = 0;
            bank = 0;
        }
    }

    @Override
    public String toString() {
        return "FotaBlockRequest{" +
                "blockRequested=" + blockRequested +
                ", bank=" + bank +
                '}';
    }
}
