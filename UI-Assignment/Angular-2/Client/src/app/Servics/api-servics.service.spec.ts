import { TestBed } from '@angular/core/testing';

import { ApiServicsService } from './api-servics.service';

describe('ApiServicsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiServicsService = TestBed.get(ApiServicsService);
    expect(service).toBeTruthy();
  });
});
