import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../models/user';
import { environment } from 'environments/environment';

@Injectable()
export class UserService {

 constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(environment.apiUrl + '/rest/users');
    }

    getById(id: number) {
        return this.http.get(environment.apiUrl + '/rest/users/' + id);
    }

    register(user: User) {
        return this.http.post(environment.apiUrl + '/rest/users/create', user);
    }

}
