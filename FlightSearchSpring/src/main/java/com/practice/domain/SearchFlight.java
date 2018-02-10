package com.practice.domain;

import java.util.Date;

public class SearchFlight {
	private String origin;
	private String destination;
	private Date timeDeparture;
	
	public SearchFlight() {}

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

	public SearchFlight(String origin, String destination) {
		super();
		this.origin = origin;
		this.destination = destination;
		//this.timeDeparture = timeDeparture;
	}
	
	
	
}
