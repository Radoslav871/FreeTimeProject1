import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../auth.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  templateUrl: 'auth-sign-in.component.html',
  styleUrls: ['auth-sign-in.component.scss']
})

export class AuthSignInComponent implements OnInit {

  // @ts-ignore
  formGroup: FormGroup;

  constructor(private router: Router, private authService: AuthService, private formBuilder: FormBuilder) {
    const navigation = this.router.getCurrentNavigation();
  }

  ngOnInit(): void {
    this.createForm();
  }

  private createForm(): FormGroup {
    return this.formGroup = this.formBuilder.group({
      username: [],
      password: []
    })
  }
}
