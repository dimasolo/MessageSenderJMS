package com.dimasolovey.datapacket;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashPosition extends DataPacket {

    private byte crashId;
    private byte resolution;
    private byte pktCounter;
    private byte crashType;
    private ArrayList<Position> listPositions = null;

    public CrashPosition() {
    }

    public CrashPosition(JsonObject crashPosition) {
       try {
            crashId = crashPosition.get("crashId").getAsByte();
            resolution = crashPosition.get("resolution").getAsByte();
            pktCounter = crashPosition.get("pktCounter").getAsByte();
            crashType = crashPosition.get("crashType").getAsByte();
            this.listPositions = new ArrayList<Position>();
            JsonArray listPositions = crashPosition.get("listPositions").getAsJsonArray();
            for (int i = 0; i < listPositions.size() ; i++) {
                JsonObject positionObject = listPositions.get(i).getAsJsonObject();
                Position position = new Position(positionObject);
                this.listPositions.add(position);
            }
        } catch(Exception ex) {
            crashId = 0;
            resolution = 0;
            pktCounter = 0;
            crashType = 0;
            listPositions = null;
        }
    }

    @Override
    public String toString() {
        return "CrashPosition{" +
                "crashId=" + crashId +
                ", resolution=" + resolution +
                ", pktCounter=" + pktCounter +
                ", crashType=" + crashType +
                ", listPositions=" + listPositions +
                '}';
    }
}
