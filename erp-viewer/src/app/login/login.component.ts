import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
@ViewChild('f') loginForm: NgForm;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private authenticationService: AuthenticationService) { }

    // On submit button click
    onSubmit() {
        //this.loginForm.reset();
        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.authenticationService.login(this.loginForm.value.username, this.loginForm.value.password)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate(['/dashboard/dashbord1']);
                },
                error => {
                    // this.alertService.error(error);
                    // this.loading = false;
                });
    }
    // On Forgot password link click
    onForgotPassword() {
        this.router.navigate(['forgotpassword'], { relativeTo: this.route.parent });
    }
    // On registration link click
    onRegister() {
        this.router.navigate(['register'], { relativeTo: this.route.parent });
    }

}
