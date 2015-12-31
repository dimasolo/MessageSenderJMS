package com.dimasolovey.datapacket;

import com.dimasolovey.utilites.CrashSampleDataItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashMaxMinAccelerations extends DataPacket {

    private byte crashId;
    private short[] max = new short[CrashSampleDataItem.MAX_NUM_ACCELERATION_AXIS];
    private short[] min = new short[CrashSampleDataItem.MAX_NUM_ACCELERATION_AXIS];

    public CrashMaxMinAccelerations() {
    }

    public CrashMaxMinAccelerations(JsonObject crashMaxMinAccelerations) {
        try {
            crashId = crashMaxMinAccelerations.get("crashId").getAsByte();
            JsonArray max = crashMaxMinAccelerations.get("max").getAsJsonArray();
            JsonArray min = crashMaxMinAccelerations.get("min").getAsJsonArray();
            for (int i = 0; i < this.max.length; i++) {
                this.max[i] = max.get(i).getAsShort();
                this.min[i] = min.get(i).getAsShort();
            }
        } catch (Exception ex) {
            crashId = 0;
            max = null;
            min = null;
        }
    }

    @Override
    public String toString() {
        return "CrashMaxMinAccelerations{" +
                "crashId=" + crashId +
                ", max=" + Arrays.toString(max) +
                ", min=" + Arrays.toString(min) +
                '}';
    }
}
