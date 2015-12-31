package com.dimasolovey.utilites;

import java.util.Formatter;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashSampleDataItem {
    public static final int MAX_NUM_ACCELERATION_AXIS = 3;

    private short[] data;

    public CrashSampleDataItem()
    {
        data = new short[MAX_NUM_ACCELERATION_AXIS];
    }

    public void setData ( short[] data )
    {
        this.data = data;
    }


    public short[] getData()
    {
        return this.data;
    }

    @Override

    public String toString() {
        Formatter formatter = new Formatter();
        String returnValue;
        formatter.format( "CrashSampleDataItem [x=%+6d y=%+6d z=%+6d]", data[0], data[1], data[2]);
        returnValue = formatter.toString();
        formatter.close();
        return returnValue;
    }
}
