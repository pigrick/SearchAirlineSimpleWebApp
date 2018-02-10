package com.practice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.domain.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
	public Flight findById(int id);
	public List<Flight> findByOriginIgnoreCaseLikeAndDestinationIgnoreCaseLikeAndTimeDepartureBetween(
			String origin, String destination, Date timeDeparturebegin, Date timeDepartureEnd);
}