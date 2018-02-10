package com.practice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.domain.Flight;
import com.practice.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getFlights(){
		return flightRepository.findAll();
	}
	
	public List<Flight> getSearchFlights(String origin, String destination, String timeDeparture) throws ParseException{
		return flightRepository.findByOriginIgnoreCaseLikeAndDestinationIgnoreCaseLikeAndTimeDepartureBetween
				("%" + origin + "%", "%" + destination +"%", 
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(timeDeparture + " 00:00:00"),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(timeDeparture + " 23:59:59"));
	}
	
	public Flight save(Flight flight){
		return flightRepository.save(flight);
	}
}
