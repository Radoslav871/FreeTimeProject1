import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../auth.service";

@Component({
  selector: 'auth-register',
  templateUrl: 'register.component.html',
  styleUrls: ['register.component.scss']
})

export class RegisterComponent implements OnInit {

  public formGroup: FormGroup | undefined;
  private formBuilder: any;


  constructor(formBuilder: FormBuilder, private route: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.formGroup = this.createForm();
  }

  onSubmit({value: valid}: { value: RegisterForm, valid: boolean }){
  }

  private createForm() {
    return this.formGroup = this.formBuilder.group({
      email: [],
      username: [],
      password: [],
    })
  }
}

export class RegisterForm {
  email: string;
  password: string;
  userName: string;


  constructor(email: string, password: string, userName: string) {
    this.email = email;
    this.password = password;
    this.userName = userName;
  }
}
