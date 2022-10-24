import {NgModule} from "@angular/core";
import {EmptyScreenLayoutComponent} from "./empty-screen-layout.component";
import {RouterModule} from "@angular/router";
import {emptyScreenLayoutRoutes} from "./empty-screen-layout.routes";

@NgModule({
  declarations:[
    EmptyScreenLayoutComponent,
  ],
  imports: [
    RouterModule.forChild(emptyScreenLayoutRoutes),
  ],
})

export class EmptyScreenLayoutModule{

}
