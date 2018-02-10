import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from "../component/welcome.component";
import { FlightlistComponent } from "../component/Flightlist.component";
import { SearchFlightComponent } from "../component/searchflight.component";

const route: Routes = [
    {
        path: "",
        component: WelcomeComponent
    },
    {
        path: "flights",
        component: FlightlistComponent
    },
    {
        path: "search",
        component: SearchFlightComponent
    }
]

@NgModule({
    imports:[
        RouterModule.forRoot(route)
    ],
    exports:[
        RouterModule
    ]
})
export class AppRoutingModule{}
