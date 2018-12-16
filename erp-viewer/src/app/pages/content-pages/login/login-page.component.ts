import { Component, ViewChild, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../../../services/authentication.service';

@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.scss']
})

export class LoginPageComponent implements OnInit {

    @ViewChild('f') loginForm: NgForm;
    returnUrl: string;


    constructor(private router: Router,
        private route: ActivatedRoute,
        private authenticationService: AuthenticationService) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    
    // On submit button click
    onSubmit() {
        console.log(this.loginForm.value["inputUser"]);
//        this.loginForm.reset();
//        this.loading = true;
        this.authenticationService.login(this.loginForm.value["inputUser"], this.loginForm.value["inputPass"])
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
//                    this.alertService.error(error);
//                    this.loading = false;
                    console.log(error);
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