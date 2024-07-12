import { Location } from "@angular/common";
import { Component, ChangeDetectionStrategy, signal, OnInit } from '@angular/core';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatIconModule } from "@angular/material/icon";
import { FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardActions } from "@angular/material/card";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatCardModule } from "@angular/material/card";
import { User } from '../../model/user';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    MatFormFieldModule, 
    MatInputModule, 
    MatIconModule, 
    ReactiveFormsModule,
    MatCardActions,
    MatToolbarModule,
    MatCardModule
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.scss'
})
export class LoginFormComponent implements OnInit{
  
  form!: FormGroup
  login: String = ''
  password = ''

constructor(private formBuilder: NonNullableFormBuilder,
            private location: Location,
            private route: ActivatedRoute
){
  this.form = new FormGroup({
    login: new FormControl(''),
    password: new FormControl('')
  });
}

  ngOnInit() {
    //const user: User = this.route.snapshot.data['login'];
    this.form = this.formBuilder.group({
      login: [this.login, [Validators.required]],
      password: [this.password, [Validators.required]]
    })  
  }

  onSubmit(){
    this.login = this.form.value.login
    this.password = this.form.value.password
  }
}
