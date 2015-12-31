package com.dimasolovey.utilites;

import java.util.Date;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class Timestamp {
    public static final long MILLI_SECONDS_FROM_1ST_GEN_2000 = 946684800000L;
    private Date ts = null;

    public Timestamp ()
    {
        ts = new Date (MILLI_SECONDS_FROM_1ST_GEN_2000);
    }

    public Timestamp ( long time )
    {
        ts = new Date (time);
    }


    public long getTime ()
    {
        return ts.getTime();
    }

    public void setTime (long time)
    {
        ts.setTime(time);
    }


    public void setTimeSecFrom1Gen2000 ( long timeSecFrom1Gen2000 )
    {
        ts.setTime(MILLI_SECONDS_FROM_1ST_GEN_2000 + timeSecFrom1Gen2000 * 1000);
    }

    public long getTimeSecFrom1Gen2000 ()
    {
        return ((ts.getTime()-MILLI_SECONDS_FROM_1ST_GEN_2000)/1000);
    }

    @Override
    public String toString()
    {
        return "Timestamp [timestamp=" + (ts != null ? ts.toString() : "") + "]";
    }
}
