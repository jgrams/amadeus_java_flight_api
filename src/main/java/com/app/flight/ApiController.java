package com.app.flight;

import com.amadeus.resources.FlightOrder;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPrice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/api")
public class ApiController {
	@GetMapping("/")
	public String hello() {
		return "Hello World Travel!";
	}

	@GetMapping("/locations")
	public String locations(@RequestParam(required=true) String keyword) {
		try {
			Location[] results = AmadeusConnect.INSTANCE.location(keyword);
			return AmadeusConnect.INSTANCE.toJson(results[0]);
		} catch (ResponseException e) {
			return e.getDescription();
		}
	}

	@GetMapping("/flights")
	public String flights(@RequestParam(required=true) String origin, 
						  @RequestParam(required=true) String destination,
						  @RequestParam(required=true) String departDate,
						  @RequestParam(required=true) String adults,
						  @RequestParam(defaultValue="") String returnDate) {
		try {
			FlightOfferSearch[] search = AmadeusConnect.INSTANCE.flights(origin, destination, departDate, returnDate, adults);
			return AmadeusConnect.INSTANCE.toJson(search[0]);
		} catch (ResponseException e) {
			return e.getDescription();
		}
	}
	
	@PostMapping("/confirm") 
	public String confirm(@RequestBody(required=true) FlightOfferSearch search) {
		try {
			FlightPrice results = AmadeusConnect.INSTANCE.confirm(search);
			return AmadeusConnect.INSTANCE.toJson(results);
		} catch (ResponseException e) {
			return e.getDescription();
		}
	}

	@GetMapping("/order")
	public String order(@RequestBody(required=true) FlightPrice offer) {
		try {
			FlightOrder results = AmadeusConnect.INSTANCE.order(offer);
			return AmadeusConnect.INSTANCE.toJson(results);
		} catch (ResponseException e) {
			return e.getDescription();
		}
	}
}