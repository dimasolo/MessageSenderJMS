package com.dimasolovey.messagesender_and_queues.rx_queue;

import com.dimasolovey.datapacket.*;
import com.dimasolovey.datapacket.Error;
import com.dimasolovey.utilites.PacketNames;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

/**
 * Created by dmitry.solovey on 05.01.2016.
 */
public class MessageToSendFromRXQueue {
    private static IMEI imei;
    private static DataPacket accelerationInfo;
    private static DataPacket alarmNotification;
    private static DataPacket alarmNotificationWithID;
    private static DataPacket analogInfo;
    private static DataPacket analogInfoExtended;
    private static DataPacket areaLogInfo;
    private static DataPacket axis6Info;
    private static DataPacket canInputData;
    private static DataPacket canOutputCommand;
    private static DataPacket cellInfo;
    private static DataPacket cellInfoExt;
    private static DataPacket crashData;
    private static DataPacket crashGyroData;
    private static DataPacket changeStatus;
    private static DataPacket crashMaxMinAccelerations;
    private static DataPacket crashMaxModuleAccelerations;
    private static DataPacket crashNotification;
    private static DataPacket position;
    private static DataPacket crashPosition;
    private static DataPacket debug;
    private static DataPacket debugWithDumpData;
    private static DataPacket driverId;
    private static DataPacket drivingBehavior;
    private static DataPacket engineBlock;
    private static DataPacket error;
    private static DataPacket esCallNotification;
    private static DataPacket eventNotification;
    private static DataPacket flash;
    private static DataPacket fotaBlockData;
    private static DataPacket fotaBlockRequest;
    private static DataPacket fotaManagement;
    private static DataPacket gpsDrivingBehavior;
    private static DataPacket gpsInfoDetail;
    private static DataPacket iccId;
    private static DataPacket ioStatus;
    private static DataPacket lockUnlock;
    private static DataPacket logAck;
    private static DataPacket logicalStatus;
    private static DataPacket MSISDNInfo;
    private static DataPacket odometerInfo;
    private static DataPacket parameters;
    private static DataPacket positionWithDOP;
    private static DataPacket privacy;
    private static DataPacket privacyInfo;
    private static DataPacket reset;
    private static DataPacket swVersion;
    private static DataPacket sysInfo;
    private static DataPacket terminalId;
    private static DataPacket trackingManagement;
    private static DataPacket trackingPosition;
    private static DataPacket transmissionMode;
    private static DataPacket tripInfo;
    private static DataPacket tripInfoDetailed;
    private static DataPacket wiMetaConfiguration;
    private static JsonParser jsonParser;

    public static synchronized String getMessageFromJsonFormat (String jsonMessage, long timestamp) {
        try {
            Map<String,JsonObject> dataPacketsMap = new HashMap<String, JsonObject>();
            List<DataPacket> listOfDataPackets = new ArrayList<DataPacket>();
            jsonParser = new JsonParser();
            Object object = jsonParser.parse(jsonMessage);
            JsonObject jsonObject = (JsonObject) object;
            imei = new IMEI((JsonObject) jsonObject.get("imei"));
            JsonArray dataPackets = jsonObject.get("dataPackets").getAsJsonArray();
            for (int i = 0; i < dataPackets.size() ; i++) {
                JsonArray array = dataPackets.get(i).getAsJsonArray();
                String key = array.get(0).getAsString();
                JsonObject value = array.get(1).getAsJsonObject();
                dataPacketsMap.put(key, value);
            }
            Iterator iterator = dataPacketsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonObject> pair = (Map.Entry) iterator.next();
                String packetName = pair.getKey();
                int dotPosition = packetName.lastIndexOf(".");
                String key = packetName.substring(dotPosition+1);
                JsonObject value = pair.getValue();
                switch (PacketNames.valueOf(key)) {
                    case AccelerationInfo: {
                        accelerationInfo = new AccelerationInfo(value);
                        listOfDataPackets.add(accelerationInfo);
                        break;
                    }
                    case AlarmNotification: {
                        alarmNotification = new AlarmNotification(value);
                        listOfDataPackets.add(alarmNotification);
                        break;
                    }
                    case AlarmNotificationWithId: {
                        alarmNotificationWithID = new AlarmNotificationWithID(value);
                        listOfDataPackets.add(alarmNotificationWithID);
                        break;
                    }
                    case AnalogInfo: {
                        analogInfo = new AnalogInfo(value);
                        listOfDataPackets.add(analogInfo);
                        break;
                    }
                    case AnalogInfoExtended: {
                        analogInfoExtended = new AnalogInfoExtended(value);
                        listOfDataPackets.add(analogInfoExtended);
                        break;
                    }
                    case AreaLogInfo: {
                        areaLogInfo = new AreaLogInfo(value);
                        listOfDataPackets.add(areaLogInfo);
                        break;
                    }
                    case Axis6Info: {
                        axis6Info = new Axis6Info(value);
                        listOfDataPackets.add(axis6Info);
                        break;
                    }
                    case CANInputData: {
                        canInputData = new CANInputData(value);
                        listOfDataPackets.add(canInputData);
                        break;
                    }
                    case CANOutputCommand: {
                        canOutputCommand = new CANOutputCommand(value);
                        listOfDataPackets.add(canOutputCommand);
                        break;
                    }
                    case CellInfo: {
                        cellInfo = new CellInfo(value);
                        listOfDataPackets.add(cellInfo);
                        break;
                    }
                    case ChangeStatus: {
                        changeStatus = new ChangeStatus(value);
                        listOfDataPackets.add(changeStatus);
                        break;
                    }
                    case CellInfoExt: {
                        cellInfoExt = new CellInfoExt(value);
                        listOfDataPackets.add(cellInfoExt);
                        break;
                    }
                    case CrashData: {
                        crashData = new CrashData(value);
                        listOfDataPackets.add(crashData);
                        break;
                    }
                    case CrashGyroData: {
                        crashGyroData = new CrashGyroData(value);
                        listOfDataPackets.add(crashGyroData);
                        break;
                    }
                    case CrashMaxMinAccelerations: {
                        crashMaxMinAccelerations = new CrashMaxMinAccelerations(value);
                        listOfDataPackets.add(crashMaxMinAccelerations);
                        break;
                    }
                    case CrashMaxModuleAccelerations: {
                        crashMaxModuleAccelerations = new CrashMaxModuleAccelerations(value);
                        listOfDataPackets.add(crashMaxModuleAccelerations);
                        break;
                    }
                    case CrashNotification: {
                        crashNotification = new CrashNotification(value);
                        listOfDataPackets.add(crashNotification);
                        break;
                    }
                    case Position: {
                        position = new Position(value);
                        listOfDataPackets.add(position);
                        break;
                    }
                    case CrashPosition: {
                        crashPosition = new CrashPosition(value);
                        listOfDataPackets.add(crashPosition);
                        break;
                    }
                    case Debug: {
                        debug = new Debug(value);
                        listOfDataPackets.add(debug);
                        break;
                    }
                    case DebugWithDumpData: {
                        debugWithDumpData = new DebugWithDumpData(value);
                        listOfDataPackets.add(debugWithDumpData);
                        break;
                    }
                    case DriverId: {
                        driverId = new DriverId(value);
                        listOfDataPackets.add(driverId);
                        break;
                    }
                    case DrivingBehavior: {
                        drivingBehavior = new DrivingBehavior(value);
                        listOfDataPackets.add(drivingBehavior);
                        break;
                    }
                    case EngineBlock: {
                        engineBlock = new EngineBlock(value);
                        listOfDataPackets.add(engineBlock);
                        break;
                    } case Error: {
                        error = new Error(value);
                        listOfDataPackets.add(error);
                        break;
                    }
                    case ESCallNotification: {
                        esCallNotification = new ESCallNotification(value);
                        listOfDataPackets.add(esCallNotification);
                        break;
                    }
                    case EventNotification: {
                        eventNotification = new EventNotification(value);
                        listOfDataPackets.add(eventNotification);
                        break;
                    }
                    case Flash: {
                        flash = new Flash(value);
                        listOfDataPackets.add(flash);
                        break;
                    }
                    case FotaBlockData: {
                        fotaBlockData = new FotaBlockData(value);
                        listOfDataPackets.add(fotaBlockData);
                        break;
                    }
                    case FotaBlockRequest: {
                        fotaBlockRequest = new FotaBlockRequest(value);
                        listOfDataPackets.add(fotaBlockRequest);
                        break;
                    }
                    case FotaManagement: {
                        fotaManagement = new FotaManagement(value);
                        listOfDataPackets.add(fotaManagement);
                        break;
                    }
                    case GpsDrivingBehavior: {
                        gpsDrivingBehavior = new GpsDrivingBehavior(value);
                        listOfDataPackets.add(gpsDrivingBehavior);
                        break;
                    }
                    case GPSInfoDetail: {
                        gpsInfoDetail = new GPSInfoDetail(value);
                        listOfDataPackets.add(gpsInfoDetail);
                        break;
                    }
                    case ICCID: {
                        iccId = new ICCID(value);
                        listOfDataPackets.add(iccId);
                        break;
                    }
                    case IOStatus: {
                        ioStatus = new IOStatus(value);
                        listOfDataPackets.add(ioStatus);
                        break;
                    }
                    case LockUnlock: {
                        lockUnlock = new LockUnlock(value);
                        listOfDataPackets.add(lockUnlock);
                        break;
                    }
                    case LogAck: {
                        logAck = new LogAck(value);
                        listOfDataPackets.add(logAck);
                        break;
                    }
                    case LogicalStatus: {
                        logicalStatus = new LogicalStatus(value);
                        listOfDataPackets.add(logicalStatus);
                        break;
                    }
                    case MSISDNInfo: {
                        MSISDNInfo = new MSISDNInfo(value);
                        listOfDataPackets.add(MSISDNInfo);
                        break;
                    }
                    case OdometerInfo: {
                        odometerInfo = new OdometerInfo(value);
                        listOfDataPackets.add(odometerInfo);
                        break;
                    }
                    case Parameters: {
                        parameters = new Parameters(value);
                        listOfDataPackets.add(parameters);
                        break;
                    }
                    case PositionWithDOP: {
                        positionWithDOP = new PositionWithDOP(value);
                        listOfDataPackets.add(positionWithDOP);
                        break;
                    }
                    case Privacy: {
                        privacy = new Privacy(value);
                        listOfDataPackets.add(privacy);
                        break;
                    }
                    case PrivacyInfo: {
                        privacyInfo = new PrivacyInfo(value);
                        listOfDataPackets.add(privacyInfo);
                        break;
                    }
                    case Reset: {
                        reset = new Reset(value);
                        listOfDataPackets.add(reset);
                        break;
                    }
                    case SwVersion: {
                        swVersion = new SwVersion(value);
                        listOfDataPackets.add(swVersion);
                        break;
                    }
                    case SysInfo: {
                        sysInfo = new SysInfo(value);
                        listOfDataPackets.add(sysInfo);
                        break;
                    }
                    case TerminalId: {
                        terminalId = new TerminalId(value);
                        listOfDataPackets.add(terminalId);
                        break;
                    }
                    case TrackingManagement: {
                        trackingManagement = new TrackingManagement(value);
                        listOfDataPackets.add(trackingManagement);
                        break;
                    }
                    case TrackingPosition: {
                        trackingPosition = new TrackingPosition(value);
                        listOfDataPackets.add(trackingPosition);
                        break;
                    }
                    case TransmissionMode: {
                        transmissionMode = new TransmissionMode(value);
                        listOfDataPackets.add(transmissionMode);
                        break;
                    }
                    case TripInfo: {
                        tripInfo = new TripInfo(value);
                        listOfDataPackets.add(tripInfo);
                        break;
                    }
                    case TripInfoDetailed: {
                        tripInfoDetailed = new TripInfoDetailed(value);
                        listOfDataPackets.add(tripInfoDetailed);
                        break;
                    }
                    case WiMetaConfiguration: {
                        wiMetaConfiguration = new WiMetaConfiguration(value);
                        listOfDataPackets.add(wiMetaConfiguration);
                        break;
                    }
                    default: break;
                }
            }
            String message = "RX:" + imei + "," + "Timestamp{" + "timestamp=" + timestamp + "}" + ",";
            for (int i = 0; i < listOfDataPackets.size() ; i++) {
                if (i == listOfDataPackets.size() - 1) {
                    message = message + listOfDataPackets.get(i).toString() + "\r\n";
                } else {
                    message = message + listOfDataPackets.get(i).toString() + ",";
                }
            }
            return message;
        } catch (Exception ex) {
            return "";
        }
    }
}
