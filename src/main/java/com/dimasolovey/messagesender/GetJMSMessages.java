package com.dimasolovey.messagesender;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;
import javax.jms.Message;
/**
 * Created by dmitry.solovey on 16.12.2015.
 */
public class GetJMSMessages {
    private static ActiveMQConnectionFactory connectionFactory = null;
    private static Connection connection = null;
    private static Session session;
    private static Destination destination;
    private static String queue = "dev.dev.msy.queue.rx";
    private static String login = "admin";
    private static String password = "admin";
    private static String activeMQURL = "failover://tcp://192.168.4.31:61616";

    public static Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws Exception{
      // MessageToSendFromRXQueue.getMessageFromJsonFormat("{\"imei\":{\"imei\":\"356917052931388F\",\"imeiNotEncoded\":\"356917052931388\",\"imeiBinary\":\"NWkXBSkxOI8=\",\"valid\":true},\"mxpVersion\":1,\"timestamp\":null,\"packet\":0,\"packetValid\":false,\"timestampValid\":false,\"dataPackets\":[[\"msy.mxp.datapacket.v1.SysInfo\",{\"spare\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":46,\"id\":11}],[\"msy.mxp.datapacket.v1.SwVersion\",{\"product\":12,\"transport\":1,\"application\":1,\"label\":113,\"ver\":12,\"bank\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":10,\"id\":2}],[\"msy.mxp.datapacket.v1.IOStatus\",{\"ioStatus\":6,\"ioDirections\":120,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":62,\"id\":15}],[\"msy.mxp.datapacket.v1.LogicalStatus\",{\"logicalStatus\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":66,\"id\":16}],[\"msy.mxp.datapacket.v1.PositionWithDOP\",{\"latitude\":0.0,\"longitude\":0.0,\"altitude\":0,\"speed\":0,\"course\":0,\"gpsNumSatellite\":0,\"glonassNumSatellite\":0,\"fixValid\":false,\"timeValid\":true,\"wgs84degMinFormat\":false,\"glonass\":true,\"fixMode\":1,\"vdop\":23,\"pdop\":23,\"hdop\":23,\"timestamp\":{\"time\":1451910222000},\"sizeDynamic\":0,\"type\":2,\"dataPacket\":162,\"id\":40}],[\"msy.mxp.datapacket.v1.GPSInfoDetail\",{\"pdop\":23.1,\"hdop\":23.1,\"vdop\":23.1,\"cno\":0,\"cnoMaxGps\":0,\"cnoMaxGnss\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":218,\"id\":54}],[\"msy.mxp.datapacket.v1.CellInfo\",{\"lac\":27168,\"cellID\":2462,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":74,\"id\":18}],[\"msy.mxp.datapacket.v1.AreaLogInfo\",{\"areaLogSize\":2850816,\"usedSize\":0,\"sentAcked\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":130,\"id\":32}],[\"msy.mxp.datapacket.v1.AnalogInfoExtended\",{\"temperature\":11,\"vbattExt\":15.1,\"vbattInt\":7.4,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":270,\"id\":67}],[\"msy.mxp.datapacket.v1.ChangeStatus\",{\"status\":0,\"newStatus\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":18,\"id\":4}],[\"msy.mxp.datapacket.v1.OdometerInfo\",{\"odometer\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":174,\"id\":43}]],\"persistent\":false,\"compressed\":false}", 1451910222000L);
     //  MessageToSend.getMessageFromJsonFormat("{\"imei\":{\"imei\":\"355504062295482F\",\"imeiNotEncoded\":\"355504062295482\",\"imeiBinary\":\"NVUEBiKVSC8=\",\"valid\":true},\"mxpVersion\":1,\"timestamp\":null,\"packet\":0,\"packetValid\":false,\"timestampValid\":false,\"dataPackets\":[[\"msy.mxp.datapacket.v1.LogData\",{\"log\":[],\"remaining\":0,\"sizeDynamic\":0,\"size\":0,\"handle\":1,\"type\":1,\"dataPacket\":57,\"id\":14}]],\"persistent\":false,\"compressed\":false}",1450866988000L);
        Thread stopThread = new Thread(new StopApplication());
        stopThread.start();
        Thread logThread = new Thread(new GetJMSMessagesFromLog());
        Thread eventThread = new Thread(new GetJMSMessagesFromEvent());
        Thread alarmThread = new Thread(new GetJMSMessagesFromAlarm());
        Thread rxThread = new Thread(new GetJMSMessagesFromRX());
        logThread.start();
        eventThread.start();
        alarmThread.start();
        rxThread.start();

/*
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
                            String messageToSend = MessageToSendFromLogQueue.getMessageFromJsonFormat(textMessage.getText());
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
        Thread thread = new Thread(new StopApplication());
        thread.run();
*/
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
