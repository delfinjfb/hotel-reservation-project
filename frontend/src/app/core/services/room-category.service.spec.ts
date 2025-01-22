import { TestBed } from '@angular/core/testing';

import { RoomCategoryService } from './room-category.service';

describe('RoomCategoryService', () => {
  let service: RoomCategoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoomCategoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
