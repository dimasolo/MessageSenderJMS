package com.dimasolovey.messagesender_and_queues.event_queue;

import com.dimasolovey.messagesender_and_queues.sender.MessageSender;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by dmitry.solovey on 05.01.2016.
 */
public class GetJMSMessagesFromEvent implements Runnable {
    private static ActiveMQConnectionFactory connectionFactory = null;
    private static Connection connection = null;
    private static Session session;
    private static Destination destination;
    private static String queue = "dev.msy.queue.event.fwd";
    private static String login = "admin";
    private static String password = "admin";
    private static String activeMQURL = "failover://tcp://192.168.4.31:61616";

    public static Connection getConnection() {
        return connection;
    }

    @Override
    public void run() {
        connect();
        destination = getDestinationQueue();
        if (destination != null) {
            try {
                MessageConsumer consumer = session.createConsumer(destination);
                consumer.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message message) {
                        try {
                            TextMessage textMessage = (TextMessage) message;
                            long timestamp = message.getJMSTimestamp();
                            String messageToSend = MessageToSendFromEventQueue.getMessageFromJsonFormat(textMessage.getText(), timestamp);
                            MessageSender.sendMessage(messageToSend);
                        } catch (JMSException ex) {
                            ex.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void connect() {
        try {
            if (connection == null) {
                connectionFactory = getConnectionFactory();
                connection = connectionFactory.createConnection();
                connection.start();
                session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            } else {
                connection.start();
            }
        } catch (JMSException e) {
            e.printStackTrace();

        }
    }
    private static ActiveMQConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory(login,
                password, activeMQURL);
    }

    private static Destination getDestinationQueue(){
        try {
            return session.createQueue(queue);
        } catch (JMSException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
