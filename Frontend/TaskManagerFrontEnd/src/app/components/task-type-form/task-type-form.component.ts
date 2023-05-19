import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { TaskTypeDTO } from 'src/app/models/DTOs/task-type-DTO';
import { TaskType } from 'src/app/models/entities/task-type';
import { TaskTypeService } from 'src/app/services/task-type/task-type.service';

@Component({
  selector: 'app-task-type-form',
  templateUrl: './task-type-form.component.html',
  styleUrls: ['./task-type-form.component.scss']
})
export class TaskTypeFormComponent {
  taskTypeForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private taskTypeService: TaskTypeService, private location: Location) {
    this.taskTypeForm = this.formBuilder.group({
      name: ['', Validators.required],
    });
  }

  onSubmit(): void {
    console.log(this.taskTypeForm.value.name);
    if (this.taskTypeForm.valid) {
      const newTaskTypeDTO: TaskTypeDTO = {
        name: this.taskTypeForm.value.name
      };

      this.taskTypeService.addTaskType(newTaskTypeDTO).subscribe((result: TaskType) => {
        console.log('Task type added:', result);
        this.location.back();
      }, (error) => {
        console.error('Error adding task type:', error);
      });
    }
  }
}
