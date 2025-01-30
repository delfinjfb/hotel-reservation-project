import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomCategoryComponent } from './room-category.component';

describe('RoomCategoryComponent', () => {
  let component: RoomCategoryComponent;
  let fixture: ComponentFixture<RoomCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RoomCategoryComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(RoomCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
