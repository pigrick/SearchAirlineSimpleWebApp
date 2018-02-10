import { Component } from '@angular/core';
import { FormGroup, FormBuilder, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'welcome',
  templateUrl: './welcome.html',
  styles: [`
  .bgi {
    background-image: url("http://www.aldogroup.com/img/DREAMS%20TAKE%20FLIGHT/BANNER_DREAMS-TAKE-FLIGHT.jpg");
    background-repeat: no-repeat;
}
  .centerlize {
    margin-top: 5%;
    margin-bottom: auto;
    height: 100%;
}
  `]
})
export class WelcomeComponent {
  searchForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router){};

  ngOnInit(){
    this.searchForm = this.fb.group({
        origin : [],
        destination :[],
        timeDeparture : []
    })
  }

  search(form: NgForm){
    this.router.navigate(['/search', form.value]);
  }

  get origin(){
    return this.searchForm.get('origin');
  }
  get destination(){
    return this.searchForm.get('destination');
  }
  get timeDeparture(){
    return this.searchForm.get('timeDeparture');
  }
}