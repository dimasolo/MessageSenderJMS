package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 24.12.2015.
 */
public class AlarmNotificationWithID extends AlarmNotification {

    private byte alarmID;


    public AlarmNotificationWithID() {
    }

    public AlarmNotificationWithID(JsonObject alarmNotificationWithID) {
        try {
            alarmID = alarmNotificationWithID.get("alarmID").getAsByte();
            alarmStatus = alarmNotificationWithID.get("alarmStatus").getAsInt();
        } catch (Exception ex) {
            alarmID = 0;
            alarmStatus = 0;
        }
    }

    public byte getAlarmID() {
        return alarmID;
    }

    @Override
    public String toString() {
        return "AlarmNotificationWithID{" +
                "alarmID=" + alarmID + ", alarmStatus=" + alarmStatus +
                '}';
    }
}
