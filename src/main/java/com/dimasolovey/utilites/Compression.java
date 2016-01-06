package com.dimasolovey.utilites;

import org.apache.commons.net.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by dmitry.solovey on 06.01.2016.
 */
public class Compression {
    public static final int BUFFER_SIZE = 2048;

    static Inflater inflater = new Inflater();
    static Deflater deflater = new Deflater();
    static byte[] bufferCompress = new byte[BUFFER_SIZE];
    static byte[] bufferDeCompress = new byte[BUFFER_SIZE];


    public synchronized static String compress ( String strToCompress ) throws IOException {
        int count;

        byte[] byteArray = strToCompress.getBytes("UTF-8");

        deflater.reset();
        deflater.setInput(byteArray);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(byteArray.length);

        while (!deflater.finished()) {
            count = deflater.deflate(bufferCompress);
            outputStream.write(bufferCompress, 0, count);
        }

        outputStream.close();
        return Base64.encodeBase64String(outputStream.toByteArray());
    }


    public synchronized static String decompress ( String strToDecompress ) throws IOException, DataFormatException {
        int count;

        byte[] byteArray = Base64.decodeBase64(strToDecompress);

        inflater.reset();
        inflater.setInput(byteArray);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(byteArray.length);

        while (!inflater.finished()) {

            count = inflater.inflate(bufferDeCompress);
            outputStream.write(bufferDeCompress, 0, count);
        }

        outputStream.close();
        byteArray = outputStream.toByteArray();

        return new String (byteArray, 0, byteArray.length, "UTF-8");
    }
}
