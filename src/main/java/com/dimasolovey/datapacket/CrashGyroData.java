package com.dimasolovey.datapacket;

import com.dimasolovey.utilites.CrashSampleDataItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashGyroData extends DataPacket {

    private byte crashId;
    private byte pktCounter;
    private byte pktTotal;
    private byte gyroHwId;
    private byte gyroHwScaleId;
    private CrashSampleDataItem[] crashGyroData;

    public CrashGyroData() {
    }

    public CrashGyroData(JsonObject crashGyroData) {
        try {
            crashId = crashGyroData.get("crashId").getAsByte();
            pktCounter = crashGyroData.get("pktCounter").getAsByte();
            pktTotal = crashGyroData.get("pktTotal").getAsByte();
            gyroHwId = crashGyroData.get("gyroHwId").getAsByte();
            gyroHwScaleId = crashGyroData.get("gyroHwScaleId").getAsByte();
            JsonObject crashGyroSamples = crashGyroData.get("crashSamples").getAsJsonObject();
            JsonArray crashDataArray = crashGyroSamples.get("crashData").getAsJsonArray();
            this.crashGyroData = new CrashSampleDataItem[crashDataArray.size()];
            for (int i = 0; i < this.crashGyroData.length ; i++) {
                JsonObject object = crashDataArray.get(i).getAsJsonObject();
                JsonArray array = object.get("data").getAsJsonArray();
                short a[] = new short[3];
                a[0] = array.get(0).getAsShort();
                a[1] = array.get(1).getAsShort();
                a[2] = array.get(2).getAsShort();
                CrashSampleDataItem crashSimpleDataItem = new CrashSampleDataItem();
                crashSimpleDataItem.setData(a);
                this.crashGyroData[i] = crashSimpleDataItem;
            }
        } catch(Exception ex) {
           crashId = 0;
            pktCounter = 0;
            pktTotal = 0;
            gyroHwId = 0;
            gyroHwScaleId = 0;
            this.crashGyroData = null;
        }
    }

    @Override
    public String toString() {
        return "CrashGyroData{" +
                "crashId=" + crashId +
                ", pktCounter=" + pktCounter +
                ", pktTotal=" + pktTotal +
                ", gyroHwId=" + gyroHwId +
                ", gyroHwScaleId=" + gyroHwScaleId +
                ", crashGyroData=" + Arrays.toString(crashGyroData) +
                '}';
    }
}
