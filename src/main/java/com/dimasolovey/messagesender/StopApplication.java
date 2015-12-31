package com.dimasolovey.messagesender;

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
                    if (GetJMSMessages.getConnection() != null) {
                        GetJMSMessages.getConnection().close();
                        System.out.println("Connection is closed");
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
