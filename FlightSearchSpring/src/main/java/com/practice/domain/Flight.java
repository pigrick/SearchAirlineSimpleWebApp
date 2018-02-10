package com.practice.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
public class Flight {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private int flightNo;
	@NotEmpty
	private String origin;
	@NotEmpty
	private String destination;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeDeparture;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeArrival;
	@NotEmpty
	private String airline;
	
	public Flight(){}
	
	
	public Flight(int flightNo, String airline, String origin, String destination, Date timeDeparture, Date timeArrival
			) {
		super();
		this.flightNo = flightNo;
		this.origin = origin;
		this.destination = destination;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.airline = airline;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(Date timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public Date getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(Date timeArrival) {
		this.timeArrival = timeArrival;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	
	
}
