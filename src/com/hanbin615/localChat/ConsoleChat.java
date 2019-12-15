package com.hanbin615.consoleChat;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleChat {

	private Scanner scanner = new Scanner(System.in);
	private boolean end = false;
	private String name;
	
	public ConsoleChat(int port) {

        DatagramServer receiver = new DatagramServer(port);
        DatagramClient.setPort(port);
        System.out.println("come ti chiami?");
        name = scanner.nextLine();
        
		while(!end) {
			String message = scanner.nextLine();
			if (message.length() == 0) {
				// ignore
			} else if(message.charAt(0) == '/') {
				parseCommand(message);
			} else {
				try {
					System.out.println(name +":" +message);
					DatagramClient.broadcast(name +":" +message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		receiver.end();
	}

	public static void main(String[] args) {

        int port;
        if (args.length != 1) {
            port = 14567;
        } else {
            port = Integer.parseInt(args[0]);
        }
        
        new ConsoleChat(port);
	}
	
	/**
	 * read commands
	 * @param message
	 */
	public void parseCommand(String message) {
		end = true;
	}
}
