import { TestBed, inject } from '@angular/core/testing';

import { PanteonService } from './panteon.service';

describe('PanteonService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PanteonService]
    });
  });

  it('should be created', inject([PanteonService], (service: PanteonService) => {
    expect(service).toBeTruthy();
  }));
});
