package com.meadlai.iot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author meadlai
 *
 */
@RestController
@RequestMapping("weather")
public class RestAPI {
	
	//
	private static WEATHER status = WEATHER.SUNNY;

	//
	@GetMapping("/today")
	public String today() {
		return status.toString();
	}

	//
	@GetMapping("/set/{input}")
	public String set(@PathVariable int input) {
		if (input > 0) {
			status = WEATHER.SUNNY;
		} else {
			status = WEATHER.RAIN;
		}

		return "Status set to: " + status.toString();
	}

}
