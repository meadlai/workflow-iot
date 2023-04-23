package com.meadlai.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Component;

/**
 * networking tool to send UDP data
 * 
 * @author meadlai
 *
 */
@Component
public class UDPSender {

	private DatagramSocket socket;
	private InetAddress address;

	private byte[] buf;

	public UDPSender() throws SocketException, UnknownHostException {
		socket = new DatagramSocket();
	}

	public void sendEcho(String ip, int port, String msg) throws IOException {
		address = InetAddress.getByName(ip);
		buf = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
		socket.send(packet);
	}

	public void close() {
		socket.close();
	}

	public static void main(String[] args) throws IOException {
		UDPSender client = new UDPSender();
		String ip = "172.20.10.2";
		int port = 7788;
		client.sendEcho(ip, port, "off");
	}

}
