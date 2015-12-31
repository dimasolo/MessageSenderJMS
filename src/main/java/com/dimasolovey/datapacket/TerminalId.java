package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
    public class TerminalId extends DataPacket {

    private String imeiOfGSMModem;

    public TerminalId() {
    }

    public TerminalId(JsonObject terminalId) {
        try {
            imeiOfGSMModem = terminalId.get("imei").getAsString();
        } catch (Exception ex) {
            imeiOfGSMModem = "";
        }
    }

    @Override
    public String toString() {
        return "TerminalId{" +
                "imeiOfGSMModem='" + imeiOfGSMModem + '\'' +
                '}';
    }
}
