package com.dimasolovey.messagesender_and_queues;

import com.dimasolovey.messagesender_and_queues.alarm_queue.GetJMSMessagesFromAlarm;
import com.dimasolovey.messagesender_and_queues.crash_queue.GetJMSMessagesFromCrash;
import com.dimasolovey.messagesender_and_queues.event_queue.GetJMSMessagesFromEvent;
import com.dimasolovey.messagesender_and_queues.log_queue.GetJMSMessagesFromLog;
import com.dimasolovey.messagesender_and_queues.rx_queue.GetJMSMessagesFromRX;

import javax.jms.JMSException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by dmitry.solovey on 16.12.2015.
 */

public class StopApplication implements Runnable {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String string;
    @Override
    public void run() {
        while (true) {
            try {
                string = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (string.equals("stop") || string.equals("exit") || string.equals("quit")) {
                try {
                    if (GetJMSMessagesFromRX.getConnection() != null) {
                        GetJMSMessagesFromRX.getConnection().close();
                        System.out.println("Connection with RX queue is closed");
                    }
                    if (GetJMSMessagesFromAlarm.getConnection() != null) {
                        GetJMSMessagesFromAlarm.getConnection().close();
                        System.out.println("Connection with Alarm queue is closed");
                    }
                    if (GetJMSMessagesFromEvent.getConnection() != null) {
                        GetJMSMessagesFromEvent.getConnection().close();
                        System.out.println("Connection with Event queue is closed");
                    }
                    if (GetJMSMessagesFromLog.getConnection() != null) {
                        GetJMSMessagesFromLog.getConnection().close();
                        System.out.println("Connection with Log queue is closed");
                    }
                    if (GetJMSMessagesFromCrash.getConnection() != null) {
                        GetJMSMessagesFromCrash.getConnection().close();
                        System.out.println("Connection with Crash queue is closed");
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
                System.exit(0);
            }
        }
    }
}
