package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class GPSInfoDetail extends DataPacket {

    float pdop;
    float hdop;
    float vdop;
    int cno;
    int cnoMaxGps;
    int cnoMaxGnss;

    public GPSInfoDetail() {
    }

    public GPSInfoDetail(JsonObject gpsInfoDetail) {
        try {
            pdop = gpsInfoDetail.get("pdop").getAsFloat();
            hdop = gpsInfoDetail.get("hdop").getAsFloat();
            vdop = gpsInfoDetail.get("vdop").getAsFloat();
            cno = gpsInfoDetail.get("cno").getAsInt();
            cnoMaxGnss = gpsInfoDetail.get("cnoMaxGnss").getAsInt();
            cnoMaxGps = gpsInfoDetail.get("cnoMaxGps").getAsInt();
        } catch (Exception ex) {
            pdop = 0.0f;
            hdop = 0.0f;
            vdop = 0.0f;
            cno = 0;
            cnoMaxGnss = 0;
            cnoMaxGps = 0;
        }
    }

    @Override
    public String toString() {
        return "GPSInfoDetail{" +
                "pdop=" + pdop +
                ", hdop=" + hdop +
                ", vdop=" + vdop +
                ", cno=" + cno +
                ", cnoMaxGps=" + cnoMaxGps +
                ", cnoMaxGnss=" + cnoMaxGnss +
                '}';
    }
}
