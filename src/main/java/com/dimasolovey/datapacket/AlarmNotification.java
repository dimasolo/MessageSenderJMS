package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class AlarmNotification extends DataPacket{

protected int alarmStatus;

    public AlarmNotification() {
    }

    public AlarmNotification(JsonObject alarmStatus) {
        try {
            this.alarmStatus = alarmStatus.get("alarmStatus").getAsInt();
        } catch (Exception ex) {
            this.alarmStatus = 0;
        }
    }

    public int getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(int alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    @Override
    public String toString() {
        return "AlarmNotification{" +
                "alarmStatus=" + alarmStatus +
                '}';
    }
}
