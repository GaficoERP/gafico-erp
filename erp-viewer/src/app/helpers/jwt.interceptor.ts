import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import 'rxjs/add/operator/do';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/catch';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    tokenUser: string;
    constructor(private inj: Injector, private router:Router) { }
    private isAuthError(error: any): boolean {
        return error instanceof HttpErrorResponse && error.status == 401;
    }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        // add authorization header with jwt token if available
        this.tokenUser = JSON.parse(localStorage.getItem('token'));
        //console.log(this.tokenUser.token)
        if (this.tokenUser) {
            req = req.clone({
                setHeaders: {
                  
                    Authorization: 'Bearer '+this.tokenUser
                }
                
            });
        }

        return next.handle(req).do((event: HttpEvent<any>) => { 
        
            if (event instanceof HttpResponse) {
        
            }
        }, (err: any) => {
            if (err instanceof HttpErrorResponse) {
                if (err.status ===0) {
                   
               

                }
            }
        });



    }
}