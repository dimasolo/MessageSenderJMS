package com.dimasolovey.utilites;

/**
 * Created by dmitry.solovey on 25.12.2015.
 */
public class CrashSamples {
    public static final int MAX_NUM_ACCELERATION_SAMPLES = 75;
    private CrashSampleDataItem[] crashData;

    public CrashSamples()
    {
        crashData = new CrashSampleDataItem[MAX_NUM_ACCELERATION_SAMPLES];
    }

    public CrashSamples ( byte [] sampleBuffer )
    {
        crashData = new CrashSampleDataItem[MAX_NUM_ACCELERATION_SAMPLES];

        setCrashDataStream(sampleBuffer);
    }

    public CrashSampleDataItem[] getCrashData ()
    {
        return this.crashData;
    }


    public void setCrashData (CrashSampleDataItem[] mListCrashSamples)
    {
        this.crashData = mListCrashSamples;
    }


    public void setCrashDataStream (byte [] sampleBuffer) {

        if ( sampleBuffer.length % (CrashSampleDataItem.MAX_NUM_ACCELERATION_AXIS*2) != 0)
            return;

        for ( int i=0,j=0; i < sampleBuffer.length; i+=(CrashSampleDataItem.MAX_NUM_ACCELERATION_AXIS*2))
        {
            CrashSampleDataItem sample = new CrashSampleDataItem();

            sample.getData()[0] = Convert.toShort(sampleBuffer, i+0);
            sample.getData()[1] = Convert.toShort(sampleBuffer, i+2);
            sample.getData()[2] = Convert.toShort(sampleBuffer, i+4);

            crashData[j++] = sample;
        }
    }


    @Override
    public String toString()
    {
        String sValue = "CrashSamples [\n";

        for ( int i=0; i < crashData.length; i++)
        {
            if ( crashData[i] != null )
                sValue += i + ":\t" + crashData[i].toString() + "\n";
        }
        return sValue + "]";
    }
}
