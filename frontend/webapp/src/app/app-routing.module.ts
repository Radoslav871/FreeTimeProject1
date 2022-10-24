import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./common/layouts/empty/empty-screen-layout.module').then(value => value.EmptyScreenLayoutModule)
  }
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  }
)
export class AppRoutingModule {

}
