import { Component, OnInit } from '@angular/core';
import { FlightService } from '../services/flight.service';
import { Flight } from '../class/flight.class';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'flightlist',
    templateUrl: './flightlist.html',
    styles: []
})
export class FlightlistComponent implements OnInit{
  flightlist: Flight[];
  constructor(private flightService : FlightService){};
  
  ngOnInit(){
    this.getFlights();
}
    getFlights(){
        this.flightService.getFlights().subscribe(flights => this.flightlist = flights.sort((x,y) => {
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