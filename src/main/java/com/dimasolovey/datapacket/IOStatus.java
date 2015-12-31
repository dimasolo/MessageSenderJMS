package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class IOStatus extends DataPacket {

    private int ioStatus;		// physical I/O status bitmask
    private int ioDirections;	// physical I/O directions bitmask: 0=In, 1=Out [ps: it is possible to change the behavior of the pin only for general purpose I/O]

    public IOStatus() {
    }

    public IOStatus(JsonObject ioStatus) {
        try {
            this.ioStatus = ioStatus.get("ioStatus").getAsInt();
            ioDirections = ioStatus.get("ioDirections").getAsInt();
        } catch(Exception ex) {
            this.ioStatus = -1;
            ioDirections = -1;
        }
    }

    @Override
    public String toString() {
        return "IOStatus{" +
                "ioStatus=" + ioStatus +
                ", ioDirections=" + ioDirections +
                '}';
    }
}
