import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {User} from "../user";
import {UserService} from "../user.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'user-create.component',
  templateUrl 'user-create.component.html'
})
export class UserCreateComponent implements OnInit {

  // formGroup: FormGroup;
  // user: User;

  constructor(private fromBuilder: FormBuilder,
              private userService: UserService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
  }
}
