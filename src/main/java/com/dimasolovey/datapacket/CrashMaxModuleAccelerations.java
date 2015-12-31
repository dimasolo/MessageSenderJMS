package com.dimasolovey.datapacket;

import com.dimasolovey.utilites.CrashSampleDataItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashMaxModuleAccelerations extends DataPacket {

    private byte crashId;
    private short[] module = new short[CrashSampleDataItem.MAX_NUM_ACCELERATION_AXIS];

    public CrashMaxModuleAccelerations() {
    }

    public CrashMaxModuleAccelerations(JsonObject crashMaxModuleAcceleration) {
        try {
            crashId = crashMaxModuleAcceleration.get("crashId").getAsByte();
            JsonArray module = crashMaxModuleAcceleration.get("module").getAsJsonArray();
            for (int i = 0; i < this.module.length ; i++) {
                this.module[i] = module.get(i).getAsShort();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            crashId = 0;
            module = null;
        }
    }

    @Override
    public String toString() {
        return "CrashMaxModuleAccelerations{" +
                "crashId=" + crashId +
                ", module=" + Arrays.toString(module) +
                '}';
    }
}
