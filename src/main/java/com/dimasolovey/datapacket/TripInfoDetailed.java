package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class TripInfoDetailed extends TripInfo {

    private long partialTime;	// [s] Partial time
    private byte cause;

    public TripInfoDetailed(){
    }

    public TripInfoDetailed(JsonObject tripInfoDetailed) {
        try {
            partialTravelDist = tripInfoDetailed.get("partialTravelDist").getAsLong();
            partialTime = tripInfoDetailed.get("partialTime").getAsLong();
            cause = tripInfoDetailed.get("cause").getAsByte();
        } catch (Exception ex) {
            partialTravelDist = -1;
            partialTime = -1;
            cause = -1;
        }
    }

    @Override
    public String toString() {
        return "TripInfoDetailed{" +
                "partialTime=" + partialTime +
                ", cause=" + cause +
                "} " + super.toString();
    }
}
