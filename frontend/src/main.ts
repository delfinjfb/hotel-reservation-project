import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { provideHttpClient } from '@angular/common/http'; // ✅ Correct import

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes), // ✅ Routing
    provideHttpClient(), // ✅ HTTP Client for APIs
  ],
}).catch((err) => console.error(err));
