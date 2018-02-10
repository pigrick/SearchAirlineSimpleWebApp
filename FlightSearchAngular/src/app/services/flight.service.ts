import { Injectable } from '@angular/core';
import { Flight } from '../class/flight.class';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http'
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/switchMap';

@Injectable()
export class FlightService{
    constructor(private http: HttpClient){}
    
    getFlights():Observable<Flight[]> {
        return this.http.get<Flight[]>('http://localhost:3000/flights');
    }

    searchFlight(flight: Flight):Observable<Flight[]>{
        return this.http.post<Flight[]>('http://localhost:3000/flights/search', flight);
    }
}