package com.dimasolovey.datapacket;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class IMEI extends DataPacket {
    private String imei;

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    @Override
    public String toString() {
        return "IMEI{" +
                "imei='" + imei + '\'' +
                '}';
    }

    public IMEI(JsonObject imei) {
        try {
            JsonElement jsonElementImei = imei.get("imeiNotEncoded");
            String imeiValid = imei.get("valid").getAsString();
            if (imeiValid.equals("false")) {
                this.imei = null;
            }
            this.imei = jsonElementImei.getAsString();
        } catch(Exception ex) {
            this.imei = null;
        }
    }
}
