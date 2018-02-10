import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SharedModule } from './shared.module';
import { AppRoutingModule } from './routing/approuting.module';
import { WelcomeComponent } from './component/welcome.component';
import { AppComponent } from './component/app.component';
import { SearchFlightComponent } from './component/searchflight.component';
import { FlightService } from './services/flight.service';
import { FlightlistComponent } from "./component/Flightlist.component";


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    SearchFlightComponent,
    FlightlistComponent
  ],
  imports: [
    BrowserModule,
    SharedModule,
    AppRoutingModule
  ],
  providers: [FlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
