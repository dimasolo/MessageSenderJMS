package com.dimasolovey.datapacket;

import com.dimasolovey.utilites.CrashSampleDataItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class GpsDrivingBehavior extends DataPacket {

    private byte cause;
    private long value;
    private CrashSampleDataItem accelerationMean = null;

    public GpsDrivingBehavior() {
    }

    public GpsDrivingBehavior(JsonObject gpsDrivingBehavior) {
        try {
            cause = gpsDrivingBehavior.get("cause").getAsByte();
            value = gpsDrivingBehavior.get("value").getAsLong();
            JsonObject accelerationsMeanObject = gpsDrivingBehavior.get("accelerationsMean").getAsJsonObject();
            JsonArray accelerationsMeanArray = accelerationsMeanObject.get("data").getAsJsonArray();
            short a[] = new short[3];
            a[0] = accelerationsMeanArray.get(0).getAsShort();
            a[1] = accelerationsMeanArray.get(1).getAsShort();
            a[2] = accelerationsMeanArray.get(2).getAsShort();
            CrashSampleDataItem crashSampleDataItem = new CrashSampleDataItem();
            crashSampleDataItem.setData(a);
            accelerationMean = crashSampleDataItem;
        } catch(Exception ex) {
            cause = -1;
            value = -1;
            accelerationMean = null;
        }
    }

    @Override
    public String toString() {
        return "GpsDrivingBehavior{" +
                "cause=" + cause +
                ", value=" + value +
                ", accelerationMean=" + accelerationMean +
                '}';
    }
}
