import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaskType } from 'src/app/models/entities/task-type';

@Component({
  selector: 'app-task-type-form',
  templateUrl: './task-type-form.component.html',
  styleUrls: ['./task-type-form.component.scss']
})
export class TaskTypeFormComponent {
  taskTypeForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.taskTypeForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      // Add more form controls based on TaskFields
    });
  }

  onSubmit(): void {
    if (this.taskTypeForm.valid) {
      const newTaskType: TaskType = {
        id: 0, // Assign a suitable ID or handle ID generation
        name: this.taskTypeForm.value.name
      };

      // Perform further operations with the new task type, e.g., save to a database

      // Reset the form
      this.taskTypeForm.reset();
    }
  }
}
