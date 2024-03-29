import {Routes} from "@angular/router";
import {EmptyScreenLayoutComponent} from "./empty-screen-layout.component";
import {AuthSignInComponent} from "../../../auth/sign-in/auth-sign-in.component";
import {RegisterComponent} from "../../../auth/register/register.component";

export const emptyScreenLayoutRoutes: Routes = [
  {
    path: '',
    component: EmptyScreenLayoutComponent,
    children: [
      {
        path: 'auth',
        children: [
          {
            path: '',
            redirectTo: 'sign-in',
            pathMatch: 'full'
          },
          {
            path: 'sign-in',
            component: AuthSignInComponent
          },
          {
            path: 'register',
            component: RegisterComponent
          }
        ]
      }
    ]
  }
]
