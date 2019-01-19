import { Component, OnInit, ViewChild } from '@angular/core';
import { DatatableComponent } from "@swimlane/ngx-datatable/release";

import { Provider } from 'app/models/provider';
import { ConfigurationService } from '../configuation.service';

@Component({
  selector: 'app-provider',
  templateUrl: './provider.component.html',
  styleUrls: ['./provider.component.scss']
})
export class ProviderComponent implements OnInit {
        
    provider: Provider = new Provider();
    providers: Provider[] = new Array();
    enabled:boolean = true;
    
    rows = [];
    @ViewChild(DatatableComponent) table: DatatableComponent;

  constructor(private cs: ConfigurationService) { }

  ngOnInit() {
      this.getProviders();
  }
    
    save() {
        console.log(this.provider);
        this.cs.saveProvider(this.provider)
            .subscribe(data => {
                this.providers.push(data);
                this.provider = new Provider();
                this.enabled = true;
            });
    }
    
    getProviders() {
        this.cs.getProviders()
            .subscribe(data => {
                this.providers=data;
                this.rows=data;
            });
    }
    
    updateFilter(event) {
        const val = event.target.value.toLowerCase();

        // filter our data
        const temp = this.providers.filter(function (d) {
            return d.name.toLowerCase().indexOf(val) !== -1 || !val;
        });

        // update the rows
        this.rows = temp;
        // Whenever the filter changes, always go back to the first page
        this.table.offset = 0;
    }
    
    edit(row) {
        this.provider = row;
        this.enabled = false;
    }

}
