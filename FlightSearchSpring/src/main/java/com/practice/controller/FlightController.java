package com.practice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.domain.Flight;
import com.practice.service.FlightService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/flights")
	public String flightlist(Model model) {
		model.addAttribute("flights", flightService.getFlights());
		return "flightlist";
	}
	
	@RequestMapping("/flights/search")
	public String searchFlight(Model model, 
			@RequestParam String origin, @RequestParam String destination, @RequestParam String timeDeparture) throws ParseException {
		System.out.println(timeDeparture);
		
		model.addAttribute("flights", flightService.getSearchFlights(
				origin, destination, timeDeparture));
		return "flightlist";
	}
	
	@RequestMapping("/populate")
	public String populate() throws ParseException {
		Flight newFlight;
		newFlight = new Flight(113, "United", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 03:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 05:00"));
		flightService.save(newFlight);
		newFlight = new Flight(123, "Delta", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 06:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 09:00"));
		flightService.save(newFlight);
		newFlight = new Flight(213, "American Airline", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 13:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 15:00"));
		flightService.save(newFlight);
		newFlight = new Flight(333, "United", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 10:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 14:00"));
		flightService.save(newFlight);
		newFlight = new Flight(131, "Delta", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 18:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 22:00"));
		flightService.save(newFlight);
		newFlight = new Flight(413, "Delta", "Austin", "Los Angeles", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 11:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 15:00"));
		flightService.save(newFlight);
		newFlight = new Flight(113, "United", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 13:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 16:00"));
		flightService.save(newFlight);
		newFlight = new Flight(443, "American Airline", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 05:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 08:00"));
		flightService.save(newFlight);
		newFlight = new Flight(253, "United", "Austin", "Los Angeles", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 01:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 04:00"));
		flightService.save(newFlight);
		newFlight = new Flight(283, "Delta", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 11:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 15:00"));
		flightService.save(newFlight);
		newFlight = new Flight(331, "United", "Austin", "New York", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-18 22:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 03:00"));
		flightService.save(newFlight);
		newFlight = new Flight(173, "United", "Los Angeles", "Houston", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 03:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 05:00"));
		flightService.save(newFlight);
		newFlight = new Flight(155, "United", "Los Angeles", "Houston", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 11:30"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 15:00"));
		flightService.save(newFlight);
		newFlight = new Flight(188, "Delta", "Los Angeles", "Houston", 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 03:00"), 
				new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-02-19 05:00"));
		flightService.save(newFlight);
		return "redirect:/flights";
	}
}
