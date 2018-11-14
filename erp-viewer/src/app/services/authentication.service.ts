import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from 'environments/environment';

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient) { }

    login(username: string, password: string) {
        return this.http.post<any>(environment.apiUrl + '/api/auth/login', { username: username, password: password })
            .pipe(map(authToken => {
                // login successful if there's a jwt token in the response
                if (authToken && authToken.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(authToken));
                }

                return authToken;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }

}
