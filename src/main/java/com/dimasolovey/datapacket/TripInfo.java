package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class TripInfo extends DataPacket {

    protected long partialTravelDist;	// [m] Partial traveled distance

    public TripInfo() {
    }

    public TripInfo(JsonObject tripInfo) {
        try {
            partialTravelDist = tripInfo.get("partialTravelDist").getAsLong();
        } catch (Exception ex) {
            partialTravelDist = -1;
        }
    }

    @Override
    public String toString() {
        return "TripInfo{" +
                "partialTravelDist=" + partialTravelDist +
                '}';
    }
}
