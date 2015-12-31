package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

import java.util.Arrays;

/**
 * Created by dmitry.solovey on 29.12.2015.
 */
public class LockUnlock extends DataPacket {

    private byte mode;						// OBU protection mode
    private byte[] password = new byte[5];	// OBU protection password

    public LockUnlock() {
    }

    public LockUnlock(JsonObject lockUnlock) {
        try {
            mode  = lockUnlock.get("mode").getAsByte();
            password = lockUnlock.get("password").getAsString().getBytes();
        } catch(Exception ex) {
            mode = -1;
            password = null;
        }
    }

    @Override
    public String toString() {
        return "LockUnlock{" +
                "mode=" + mode +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
