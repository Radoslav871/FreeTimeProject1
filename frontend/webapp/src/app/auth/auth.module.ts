import {NgModule} from "@angular/core";
import {AuthSignInComponent} from "./sign-in/auth-sign-in.component";
import {AuthService} from "./auth.service";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  declarations: [
    AuthSignInComponent
  ],
  providers: [
    AuthService,
  ]
})

export class AuthModule {

}
