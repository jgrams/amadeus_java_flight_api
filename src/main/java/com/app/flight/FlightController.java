package com.app.flight;

import com.amadeus.exceptions.ResponseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FlightController {
	@GetMapping("/")
	public String index() {
		return "I want to get away!";
	}

	@GetMapping("/locations")
	public String locations(@RequestParam(required=true) String keyword) {
		try {
			return AmadeusConnect.INSTANCE.location(keyword);
		} catch (ResponseException e) {
			return e.getDescription();
		}
	}

	@GetMapping("/flights")
	public String flights(@RequestParam(required=true) String origin, @RequestParam(required=true) String destination) {
		try {
			return AmadeusConnect.INSTANCE.flights(origin, destination);
		} catch (ResponseException e) {
			return e.getDescription();
		}
	}
}