import { Routes } from "@angular/router";
import { LoginFormComponent } from "./container/login-form/login-form.component";
import { CarsComponent } from "./container/cars/cars.component";

export const USERS_ROUTES: Routes = [
    {
        path: '', component: CarsComponent
    },
    {
        path: 'login', component: LoginFormComponent 
    }
]