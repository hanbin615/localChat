package com.hanbin615.consoleChat;

import java.net.*;

public class DatagramServer extends Thread {
    protected DatagramSocket socket = null;
    protected byte[] buf = new byte[256];
    private int port;
    private boolean end = false;

    public DatagramServer(){
        this(14567);
    }

    public DatagramServer(int port){
        super("DatagramServer");
        this.port = port;
    }

    public void run() {
        try{
            socket = new DatagramSocket(port);
            while (!end) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println(received);
            }
        socket.close();
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    public void end(){
        end = true;
    }
}