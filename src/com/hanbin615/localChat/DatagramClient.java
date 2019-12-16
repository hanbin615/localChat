package com.hanbin615.consoleChat;

import java.net.*;
import java.io.*;

public class DatagramClient {
	
    static private int port;
    public static void broadcast(String broadcastMessage) throws IOException {
    	DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);

        byte[] buffer = broadcastMessage.getBytes();

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("192.168.1.255"), port);
        socket.send(packet);
        socket.close();
    }
    
    public static void setPort(int port) {
    	DatagramClient.port = port;
    }
}