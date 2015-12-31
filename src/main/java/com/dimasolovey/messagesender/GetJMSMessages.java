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
       MessageToSend.getMessageFromJsonFormat("{\"imei\":{\"imei\":\"355504062295482F\",\"imeiNotEncoded\":\"355504062295482\",\"imeiBinary\":\"NVUEBiKVSC8=\",\"valid\":true},\"mxpVersion\":1,\"timestamp\":null,\"packet\":0,\"packetValid\":false,\"timestampValid\":false,\"dataPackets\":[[\"msy.mxp.datapacket.v1.LogData\",{\"log\":[{\"packet\":0,\"packetValid\":false,\"timestamp\":{\"time\":1450866988000},\"dataPackets\":[[\"msy.mxp.datapacket.v1.TripInfo\",{\"partialTravelDist\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":102,\"id\":25}],[\"msy.mxp.datapacket.v1.Position\",{\"latitude\":50.466072,\"longitude\":30.500322,\"altitude\":20,\"speed\":4,\"course\":156,\"gpsNumSatellite\":1,\"glonassNumSatellite\":0,\"fixValid\":true,\"timeValid\":true,\"wgs84degMinFormat\":true,\"glonass\":true,\"fixMode\":3,\"timestamp\":{\"time\":1450866988000},\"sizeDynamic\":0,\"type\":2,\"dataPacket\":78,\"id\":19}],[\"msy.mxp.datapacket.v1.GPSInfoDetail\",{\"pdop\":3.2,\"hdop\":2.4,\"vdop\":2.0,\"cno\":37,\"cnoMaxGps\":37,\"cnoMaxGnss\":0,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":218,\"id\":54}],[\"msy.mxp.datapacket.v1.IOStatus\",{\"ioStatus\":1030,\"ioDirections\":120,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":62,\"id\":15}],[\"msy.mxp.datapacket.v1.Axis6Info\",{\"version\":0,\"id\":0,\"op\":0,\"gyro\":{\"data\":[1,2,3]},\"counter\":1,\"accelerations\":{\"data\":[1,2,3]},\"rtctime\":100,\"sizeDynamic\":0}],[\"msy.mxp.datapacket.v1.WiMetaConfiguration\",{\"version\":0,\"id\":0,\"op\":0,\"operStat\":3,\"slotID\":2,\"rfID\":100,\"sizeDynamic\":0}],[\"msy.mxp.datapacket.v1.AnalogInfoExtended\",{\"temperature\":27,\"vbattExt\":12.4,\"vbattInt\":7.4,\"sizeDynamic\":0,\"type\":2,\"dataPacket\":270,\"id\":67}]]}],\"remaining\":1,\"sizeDynamic\":56,\"size\":56,\"handle\":0,\"type\":1,\"dataPacket\":57,\"id\":14}]],\"persistent\":false,\"compressed\":false}",1450866988000L);
     //  MessageToSend.getMessageFromJsonFormat("{\"imei\":{\"imei\":\"355504062295482F\",\"imeiNotEncoded\":\"355504062295482\",\"imeiBinary\":\"NVUEBiKVSC8=\",\"valid\":true},\"mxpVersion\":1,\"timestamp\":null,\"packet\":0,\"packetValid\":false,\"timestampValid\":false,\"dataPackets\":[[\"msy.mxp.datapacket.v1.LogData\",{\"log\":[],\"remaining\":0,\"sizeDynamic\":0,\"size\":0,\"handle\":1,\"type\":1,\"dataPacket\":57,\"id\":14}]],\"persistent\":false,\"compressed\":false}",1450866988000L);
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
                            long timestamp = textMessage.getJMSTimestamp();
                            String messageToSend = MessageToSend.getMessageFromJsonFormat(textMessage.getText(),
                                    timestamp);
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
