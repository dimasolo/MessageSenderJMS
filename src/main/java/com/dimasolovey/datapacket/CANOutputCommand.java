package com.dimasolovey.datapacket;

import com.dimasolovey.utilites.Timestamp;
import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CANOutputCommand extends DataPacket {

    private byte commandID;
    private long startTime;
    private int duration;

    public CANOutputCommand()
    {
    }

    public CANOutputCommand(JsonObject canOutputCommand){
        try {
            commandID = canOutputCommand.get("commandID").getAsByte();
            JsonObject stTime = canOutputCommand.get("startTime").getAsJsonObject();
            startTime = stTime.get("time").getAsLong();
            duration =  canOutputCommand.get("duration").getAsInt();
        } catch (Exception ex) {
            commandID = 0;
            startTime = Timestamp.MILLI_SECONDS_FROM_1ST_GEN_2000;
            duration =0;
        }
    }

    @Override
    public String toString() {
        return "CANOutputCommand{" +
                "commandID=" + commandID +
                ", startTime=" + startTime +
                ", duration=" + duration +
                '}';
    }
}
