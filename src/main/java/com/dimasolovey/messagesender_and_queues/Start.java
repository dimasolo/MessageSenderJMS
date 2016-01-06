package com.dimasolovey.messagesender_and_queues;

import com.dimasolovey.messagesender_and_queues.alarm_queue.GetJMSMessagesFromAlarm;
import com.dimasolovey.messagesender_and_queues.crash_queue.GetJMSMessagesFromCrash;
import com.dimasolovey.messagesender_and_queues.event_queue.GetJMSMessagesFromEvent;
import com.dimasolovey.messagesender_and_queues.log_queue.GetJMSMessagesFromLog;
import com.dimasolovey.messagesender_and_queues.rx_queue.GetJMSMessagesFromRX;


/**
 * Created by dmitry.solovey on 16.12.2015.
 */
public class Start {
    public static void main(String[] args) throws Exception{
        Thread stopThread = new Thread(new StopApplication());
        stopThread.start();
        Thread logThread = new Thread(new GetJMSMessagesFromLog());
        Thread eventThread = new Thread(new GetJMSMessagesFromEvent());
        Thread alarmThread = new Thread(new GetJMSMessagesFromAlarm());
        Thread crashThread = new Thread(new GetJMSMessagesFromCrash());
        Thread rxThread = new Thread(new GetJMSMessagesFromRX());
        logThread.start();
        eventThread.start();
        alarmThread.start();
        crashThread.start();
        rxThread.start();
    }
}
