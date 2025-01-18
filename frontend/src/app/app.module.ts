import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';  // ✅ Correct import

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule, 
    AppRoutingModule,
    AppComponent  // ✅ Import standalone component here
  ],
  providers: [],
  bootstrap: [AppComponent]  // ✅ Bootstrapping is correct
})
export class AppModule { }
