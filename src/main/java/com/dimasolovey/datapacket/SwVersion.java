package com.dimasolovey.datapacket;

import com.google.gson.JsonObject;

/**
 * Created by dmitry.solovey on 30.12.2015.
 */
public class SwVersion extends DataPacket {

    private byte product;		// product type
    private byte transport; 	// transport layer protocol revision
    private byte application; 	// application layer protocol revision
    private byte label;			// sw version label
    private int version;		// sw version
    private byte bank; 			// sw version memory bank

    public SwVersion() {
    }

    public SwVersion(JsonObject swVersion) {
        try {
            product = swVersion.get("product").getAsByte();
            transport = swVersion.get("transport").getAsByte();
            application = swVersion.get("application").getAsByte();
            label = swVersion.get("label").getAsByte();
            version = swVersion.get("ver").getAsInt();
            bank = swVersion.get("bank").getAsByte();
        } catch (Exception ex) {
            product = -1;
            transport = -1;
            application = -1;
            label = -1;
            version = -1;
            bank = -1;
        }
    }

    @Override
    public String toString() {
        return "SwVersion{" +
                "product=" + product +
                ", transport=" + transport +
                ", application=" + application +
                ", label=" + label +
                ", version=" + version +
                ", bank=" + bank +
                '}';
    }
}
