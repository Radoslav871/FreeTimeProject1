import {NgModule} from "@angular/core";
import {UserCreateComponent} from "./create/user-create.component";
import {RouterModule} from "@angular/router";
import {UserComponent} from "./user.component";
import {UserService} from "./user.service";

@NgModule({
  declarations: [
    UserComponent,
    UserCreateComponent
  ],
  imports: [
    RouterModule.forChild([
      {
        path: '',
        component: UserComponent,
        children: [
          {
            path: 'create',
            component: UserCreateComponent
          }
        ]
      }
    ]),
  ],
  providers: [
    UserService,
  ],
  bootstrap: []
})
export class UserModule{

}
