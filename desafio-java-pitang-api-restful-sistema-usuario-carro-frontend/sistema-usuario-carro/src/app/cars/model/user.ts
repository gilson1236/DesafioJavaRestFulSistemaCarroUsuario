import { Car } from "./car";

export interface User {
    _id: string,
    firstName: string,
    lastName: string,
    email: string,
    birthday: Date,
    login: string, 
    password: string,
    phone: string,
    cars: Car[]
}
