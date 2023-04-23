package com.meadlai.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.meadlai.network.UDPSender;

import lombok.extern.slf4j.Slf4j;

/**
 * Service Task
 * <p>
 * This is configured as delegated-expression
 * </p>
 * @author meadlai
 *
 */
@Component("notify_esp32")
@Slf4j
public class DelegateServiceTask implements JavaDelegate {
	
	@Autowired 
	private UDPSender socket;
	
	@Value(value = "${iot.esp.ip:172.20.10.2}")
	private String ip;
	@Value(value = "${iot.esp.port:7788}")
	private int port;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String response = (String) execution.getVariable("response");
		log.info("DelegateServiceTask::response is: {}", response);
		String action = (String) execution.getVariable("action");
		this.socket.sendEcho(ip, port, action);
		log.info("DelegateServiceTask::action is: {}", action);

	} 

}
