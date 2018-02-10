import { Component, OnInit } from '@angular/core';
import { FlightService } from '../services/flight.service';
import { ActivatedRoute } from '@angular/router';
import { Flight } from '../class/flight.class';

@Component({
  selector: 'searchflight',
  templateUrl: './searchflight.html',
  styles: []
})
export class SearchFlightComponent implements OnInit{
    flightlist: Flight[];
    constructor(private flightService : FlightService, private route: ActivatedRoute){};

ngOnInit(){
    console.log('enter');
    this.getFlights();
}
    getFlights(){
        const flight = new Flight();
        flight.origin = this.route.snapshot.params['origin'];
        flight.destination = this.route.snapshot.params['destination'];
        flight.timeDeparture = this.route.snapshot.params['timeDeparture'];
        console.log(flight);
        this.flightService.searchFlight(flight).subscribe(flights => this.flightlist = flights.sort((x,y) => {
            if(x.timeDeparture > y.timeDeparture){
                return -1;
            } else if (x.timeDeparture > y.timeDeparture){
                return 1;
            } else {
                return 0;
            }
        }))
    }
}