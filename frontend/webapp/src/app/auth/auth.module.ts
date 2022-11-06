import {NgModule} from "@angular/core";
import {AuthSignInComponent} from "./sign-in/auth-sign-in.component";
import {AuthService} from "./auth.service";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RegisterComponent} from "./register/register.component";
import {RouterModule} from "@angular/router";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule,
    ],
  declarations: [
    AuthSignInComponent,
    RegisterComponent
  ],
  providers: [
    AuthService,
  ]
})

export class AuthModule {

}
