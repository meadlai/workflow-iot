package com.meadlai.iot;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.meadlai.network.UDPSender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UDPSenderTest {

	@Test
	public void on() throws IOException {
		UDPSender client = new UDPSender();
		String ip = "172.20.10.2";
		int port = 7788;
		client.sendEcho(ip, port, "on");
		log.info("turn on");
	}

	@Test
	public void off() throws IOException {
		UDPSender client = new UDPSender();
		String ip = "172.20.10.2";
		int port = 7788;
		client.sendEcho(ip, port, "off");
		log.info("turn off");
	}
}
