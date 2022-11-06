import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {User} from "./user";
import {RegisterForm} from "../auth/register/register.component";

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  // public register(value: RegisterForm): Observable<User> {
  //   return this.httpClient.post('/api/register/user', {
  //     email: value.email,
  //     password: value.password,
  //     userName: value.userName
  //   }).pipe(map((n => new User(n))))
  // }
}
