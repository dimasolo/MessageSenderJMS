package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashNotification extends DataPacket {

    private byte crashId;
    private byte crashCounter;
    private byte minicrashCounter;
    private byte saturationCounter;
    private short activationCounter;
    private short kinematicIndex;
    private byte scaleFactor;

    public CrashNotification() {
    }

    public CrashNotification(JsonObject crashNotification) {
        try {
            crashId = crashNotification.get("crashId").getAsByte();
            crashCounter = crashNotification.get("crashCounter").getAsByte();
            minicrashCounter = crashNotification.get("minicrashCounter").getAsByte();
            saturationCounter = crashNotification.get("saturationCounter").getAsByte();
            activationCounter = crashNotification.get("activationCounter").getAsShort();
            kinematicIndex = crashNotification.get("kinematicIndex").getAsShort();
            scaleFactor = crashNotification.get("scaleFactor").getAsByte();
        } catch (Exception ex) {
            crashId = 0;
            crashCounter = 0;
            minicrashCounter = 0;
            saturationCounter = 0;
            activationCounter = 0;
            kinematicIndex = 0;
            scaleFactor = 0;
        }
    }

    @Override
    public String toString() {
        return "CrashNotification{" +
                "crashId=" + crashId +
                ", crashCounter=" + crashCounter +
                ", minicrashCounter=" + minicrashCounter +
                ", saturationCounter=" + saturationCounter +
                ", activationCounter=" + activationCounter +
                ", kinematicIndex=" + kinematicIndex +
                ", scaleFactor=" + scaleFactor +
                '}';
    }
}
