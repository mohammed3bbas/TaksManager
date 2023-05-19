import { TestBed } from '@angular/core/testing';

import { TaskFieldService } from './task-field.service';

describe('TaskFieldService', () => {
  let service: TaskFieldService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TaskFieldService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
