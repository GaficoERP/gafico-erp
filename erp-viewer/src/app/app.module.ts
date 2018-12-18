
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from "./shared/shared.module";
import { ToastModule, ToastOptions } from 'ng2-toastr/ng2-toastr';
import { AgmCoreModule } from '@agm/core';
import { AppComponent } from './app.component';
import { ContentLayoutComponent } from "./layouts/content/content-layout.component";
import { FullLayoutComponent } from "./layouts/full/full-layout.component";
import { CustomOption } from "./shared/toastr/custom-option";
import { FormsModule } from '@angular/forms';
import { JwtInterceptor } from './helpers/jwt.interceptor';



import * as $ from 'jquery';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';


@NgModule({
    declarations: [
        AppComponent,
        FullLayoutComponent,
        ContentLayoutComponent
    ],
    imports: [
        BrowserAnimationsModule,
        AppRoutingModule,
        SharedModule,
        HttpClientModule,
        ToastModule.forRoot(),
        NgbModule.forRoot(),
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyBr5_picK8YJK7fFR2CPzTVMj6GG1TtRGo'
        }),
        FormsModule
    ],
    providers: [
      
        //Toastr providers
        { provide: ToastOptions, useClass: CustomOption },{
            provide: HTTP_INTERCEPTORS,
            useClass: JwtInterceptor,
            multi: true
          }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }