package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class EngineBlock extends DataPacket {

    private byte engineBlockId;		// Engine block identifier
    private byte mode;	// Engine block mode
    private byte values;	// Engine block command

    public EngineBlock() {
    }

    public EngineBlock(JsonObject engineBlock) {
        try {
            engineBlockId = engineBlock.get("engineBlockId").getAsByte();
            mode = engineBlock.get("mode").getAsByte();
            values = engineBlock.get("values").getAsByte();
        } catch (Exception ex) {
            engineBlockId = -1;
            mode = -1;
            values = -1;
        }
    }


    @Override
    public String toString() {
        return "EngineBlock{" +
                "engineBlockId=" + engineBlockId +
                ", mode=" + mode +
                ", values=" + values +
                '}';
    }
}
