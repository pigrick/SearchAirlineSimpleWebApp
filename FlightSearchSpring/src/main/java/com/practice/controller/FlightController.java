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
		return "redirect:/flights";
	}
}
