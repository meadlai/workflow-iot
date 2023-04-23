package com.meadlai.iot;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * Error handler
 * 
 * @author meadlai
 *
 */
@Controller
@Slf4j
public class IoTErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(Object obj) {
		log.info("Here is some-exception: {}", obj);
		return "error";
	}
}
