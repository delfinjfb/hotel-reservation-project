import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';  // Assuming you have defined routes

bootstrapApplication(AppComponent, {
    providers: [
        provideRouter(routes)  // ✅ Provides routing to standalone component
    ]
}).catch(err => console.error(err));
