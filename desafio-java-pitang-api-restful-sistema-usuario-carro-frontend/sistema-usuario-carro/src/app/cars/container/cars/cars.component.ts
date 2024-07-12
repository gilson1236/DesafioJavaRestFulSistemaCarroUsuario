import { Component } from '@angular/core';
import { LoginFormComponent } from "../login-form/login-form.component";
import { MatCardModule } from "@angular/material/card";

@Component({
  selector: 'app-cars',
  standalone: true,
  imports: [LoginFormComponent, MatCardModule],
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.scss'
})
export class CarsComponent {

}
