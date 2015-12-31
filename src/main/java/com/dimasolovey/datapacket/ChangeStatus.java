package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class ChangeStatus extends DataPacket {

    private byte status;
    private byte newStatus;

    public ChangeStatus() {
    }

    public ChangeStatus(JsonObject changeStatus) {
        try {
            status = changeStatus.get("status").getAsByte();
            newStatus = changeStatus.get("newStatus").getAsByte();
        } catch(Exception ex) {
            status = -1;
            newStatus = -1;
        }
    }

    @Override
    public String toString() {
        return "ChangeStatus{" +
                "status=" + status +
                ", newStatus=" + newStatus +
                '}';
    }
}
