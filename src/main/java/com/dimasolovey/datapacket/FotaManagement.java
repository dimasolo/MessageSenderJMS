package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class FotaManagement extends DataPacket {

    private byte typeFota;						// Fota activity type
    private boolean launchBootLoader = false;	// Option to launch boot loader immediately (true) or after the first sleep mode (false)
    private boolean restoreAreaParam = false;	// Option to restore flash area parameters with default values, and launch bootLoader immediately (true) or do nothing (false)
    private boolean eraseAreaLog = false;		// Option to erase immediately logs flash area
    private int crc32 = 0;	                    // CRC32 (Polynomial = 0x04C11DB7, Initial value = 0xFFFFFFFF) of the entire image of the OBU application
                                                // software sent (including block packet not sent, and considering the first 4 bytes as 0xFFFFFFFF (the CRC
                                                //itself in the binary file)

    public FotaManagement() {
    }

    public FotaManagement(JsonObject fotaManagement) {
        try {
            typeFota = fotaManagement.get("typeFota").getAsByte();
            launchBootLoader = fotaManagement.get("launchBootLoader").getAsBoolean();
            restoreAreaParam = fotaManagement.get("restoreAreaParam").getAsBoolean();
            eraseAreaLog = fotaManagement.get("eraseAreaLog").getAsBoolean();
            crc32 = fotaManagement.get("crc32").getAsInt();
        } catch(Exception ex) {
            typeFota = -1;
            launchBootLoader = false;
            restoreAreaParam = false;
            eraseAreaLog = false;
            crc32 = 0;
        }
    }

    @Override
    public String toString() {
        return "FotaManagement{" +
                "typeFota=" + typeFota +
                ", launchBootLoader=" + launchBootLoader +
                ", restoreAreaParam=" + restoreAreaParam +
                ", eraseAreaLog=" + eraseAreaLog +
                ", crc32=" + crc32 +
                '}';
    }
}
