package com.dimasolovey.utilites;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class Convert {

    public static Object resizeArray ( Object oldArray, int piStart )
    {
        Class<?> elementType = oldArray.getClass().getComponentType();
        int newLength = java.lang.reflect.Array.getLength(oldArray)-piStart;
        Object newArray = null;

        if ( newLength > 0 )
        {
            newArray = java.lang.reflect.Array.newInstance ( elementType, newLength );

            System.arraycopy(oldArray, piStart, newArray, 0, newLength );
        }
        return newArray;
    }


    public static Object resizeArray ( Object oldArray, int piStart, int piLen )
    {
        Class<?> elementType = oldArray.getClass().getComponentType();
        int newLength = java.lang.reflect.Array.getLength(oldArray)-piStart;
        Object newArray = null;

        newLength = Math.min(newLength, piLen);

        if ( newLength > 0 )
        {
            newArray = java.lang.reflect.Array.newInstance ( elementType, newLength );

            System.arraycopy(oldArray, piStart, newArray, 0, newLength );
        }
        return newArray;
    }


    public static short toShort ( byte[] buff, int piStartIndex  )
    {
        return (short)((((short)buff[piStartIndex+1]&0xff)<<8) | ((short)buff[piStartIndex+0]&0xff));
    }


    public static short toShort ( byte b0, byte b1 )
    {
        int app = (((int)b1&0xff)<<8) | ((int)b0&0xff);
        return (short) app;
    }


    public static int toInt ( byte[] buff )
    {
        return ( ((((int)buff[3])&0xff)<<24) | ((((int)buff[2])&0xff)<<16) | ((((int)buff[1])&0xff)<<8) |
                ((((int)buff[0])&0xff)<<0) );
    }


    public static int toInt ( byte[] buff, int piStartIndex )
    {
        return ( ((((int)buff[piStartIndex+3])&0xff)<<24) | ((((int)buff[piStartIndex+2])&0xff)<<16) |
                ((((int)buff[piStartIndex+1])&0xff)<<8) | ((((int)buff[piStartIndex+0])&0xff)<<0) );
    }


    public static int toUnsignedInt (byte b)
    {
        if ( b < 0 )
            return (int) (256 + b);
        else
            return (int) b;
    }


    public static long toUnsignedInt ( byte[] buff )
    {
        return ( ((((long)buff[3])&0xff)<<24) | ((((long)buff[2])&0xff)<<16) | ((((long)buff[1])&0xff)<<8) |
                ((((long)buff[0])&0xff)<<0) );
    }


    public static long toUnsignedInt ( byte[] buff, int piStartIndex )
    {
        return ( ((((long)buff[piStartIndex+3])&0xff)<<24) | ((((long)buff[piStartIndex+2])&0xff)<<16) |
                ((((long)buff[piStartIndex+1])&0xff)<<8) | ((((long)buff[piStartIndex+0])&0xff)<<0) );
    }


    public static long toUnsignedIntFromShort ( byte[] buff, int piStartIndex )
    {
        long lApp;
        byte[] buffOut = new byte[4];

        buffOut[0]=buff[piStartIndex];
        buffOut[1]=buff[piStartIndex+1];
        buffOut[2]=0x00;
        buffOut[3]=0x00;

        lApp = Convert.toUnsignedInt(buffOut, 0);

        return lApp;
    }


    public static byte[] toByte ( short sValue )
    {
        byte[] buff = new byte[2];

        buff[1] = (byte) ((sValue>>8) & 0xff);
        buff[0] = (byte) (sValue & 0xff);

        return buff;
    }


    public static byte[] toByte ( short sValue, byte[] buff, int offset )
    {
        buff [ offset+1 ] = (byte) ((sValue>>8) & 0xff);
        buff [ offset ] = (byte) (sValue & 0xff);

        return buff;
    }


    public static byte[] toByte ( int iValue )
    {
        byte[] buff = new byte[4];

        buff[3] = (byte) ((iValue>>24) & 0xff);
        buff[2] = (byte) ((iValue>>16) & 0xff);
        buff[1] = (byte) ((iValue>>8) & 0xff);
        buff[0] = (byte) (iValue & 0xff);

        return buff;
    }



    public static byte[] toByte ( int iValue, byte[] buff, int offset )
    {
        buff [ offset+3 ] = (byte) ((iValue>>24) & 0xff);
        buff [ offset+2 ] = (byte) ((iValue>>16) & 0xff);
        buff [ offset+1 ] = (byte) ((iValue>>8) & 0xff);
        buff [ offset ] = (byte) (iValue & 0xff);

        return buff;
    }


    public static void toByte(long l, byte[] buff, int offset)
    {
        buff [ offset+3 ] = (byte) ((((int)l)>>>24) & 0xff);
        buff [ offset+2 ] = (byte) ((((int)l)>>>16) & 0xff);
        buff [ offset+1 ] = (byte) ((((int)l)>>>8) & 0xff);
        buff [ offset ] = (byte) (((int)l) & 0xff);

    }


    public static String toHex ( byte[] buffer, int size )
    {
        String sResult = "";
        String sApp;

        if (size > buffer.length)
            size = buffer.length;

        for ( int iCont = 0; iCont < size; iCont++ )
        {
            sApp = Integer.toHexString(((int) buffer[iCont])&0xff).toUpperCase();
            if ( sApp.length() == 2 )
                sResult += sApp;
            else
                sResult += "0" + sApp;
        }
        return sResult;
    }


    public static String toHex ( byte[] buffer )
    {
        if ( null == buffer )
            return "";
        return toHex ( buffer, buffer.length );
    }


    public static byte[] toHex ( String sMsg )
    {
        byte[] baResult = null;
        byte bApp;
        if ( sMsg == null )
            return null;
        if ( sMsg.length() % 2 != 0 )
            return null;

        baResult = new byte[sMsg.length()/2];

        for ( int iCont = 0; iCont < sMsg.length()/2; iCont++ )
        {
            try {
                bApp = (byte) (getChar(sMsg.charAt(iCont*2))<<4);
                bApp |= (byte) (getChar(sMsg.charAt(iCont*2+1))&0x0f);
            } catch (Exception e) {
                return null;
            }
            baResult[iCont] = bApp;
        }
        return baResult;
    }

    private static byte getChar ( char c ) throws Exception
    {
        if (( c >= 48 ) && ( c <= 57 ))
            return (byte) (c-48);
        if (( c >= 65 ) && ( c <= 70 ))
            return (byte) (c-55);
        if (( c >= 97 ) && ( c <= 102 ))
            return (byte) (c-87);
        throw new Exception ("Value non possible");
    }


    public static String toHex ( byte[] buffer, String sSpacer )
    {
        String sResult = "";

        for ( int iCont = 0; iCont < buffer.length; iCont++ )
        {
            String sApp = Integer.toHexString(((int) buffer[iCont])&0xff).toUpperCase();
            if ( sApp.length() == 2 )
                sResult += sApp + sSpacer;
            else
                sResult += "0" + sApp + sSpacer;
        }
        return sResult;
    }


    public static byte[] ArrayCat(byte[] buff1, byte[] buff2)
    {
        byte[] buffReturn = null;

        if ( buff1 == null )
            return buff2;

        if ( buff2 == null )
            return buff1;

        buffReturn = new byte[buff1.length+buff2.length];

        System.arraycopy(buff1, 0, buffReturn, 0, buff1.length);
        System.arraycopy(buff2, 0, buffReturn, buff1.length, buff2.length);

        return buffReturn;
    }
}
