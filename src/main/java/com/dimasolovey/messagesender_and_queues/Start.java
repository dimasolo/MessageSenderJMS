package com.dimasolovey.messagesender_and_queues;

import com.dimasolovey.messagesender_and_queues.alarm_queue.GetJMSMessagesFromAlarm;
import com.dimasolovey.messagesender_and_queues.crash_queue.GetJMSMessagesFromCrash;
import com.dimasolovey.messagesender_and_queues.event_queue.GetJMSMessagesFromEvent;
import com.dimasolovey.messagesender_and_queues.log_queue.GetJMSMessagesFromLog;
import com.dimasolovey.messagesender_and_queues.rx_queue.GetJMSMessagesFromRX;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by dmitry.solovey on 16.12.2015.
 */
public class Start {
    private static int port;
    private static String host;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getPort() {
        return port;
    }

    public static String getHost() {
        return host;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Enter the host (example: 192.168.3.25) ->");
        host = reader.readLine();
        System.out.println("Enter the port (example: 3456) ->");
        port = Integer.parseInt(reader.readLine());

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
