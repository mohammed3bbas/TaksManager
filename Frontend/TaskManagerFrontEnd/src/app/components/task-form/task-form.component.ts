import { FieldValueService } from 'src/app/services/field-value/field-value.service';
import { TaskFieldService } from './../../services/task-field/task-field.service';
import { TaskService } from './../../services/task/task.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { TaskDTO } from 'src/app/models/DTOs/task-DTO';
import { Task } from 'src/app/models/entities/task';
import { TaskField } from 'src/app/models/entities/task-field';
import { FieldValueDTO } from 'src/app/models/DTOs/field-value-DTO';
import { FieldValue } from 'src/app/models/entities/field-value';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent implements OnInit {
  taskForm: FormGroup;
  taskTypeId: number = -1;
  taskFields: TaskField[] = [];
  filteredTaskFields: TaskField[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private taskService: TaskService,
    private taskFieldService: TaskFieldService,
    private fieldValueService: FieldValueService,
    private location: Location
  ) {
    this.taskForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: [''],
      dueDate: ['', Validators.required],
      taskTypeId: []
    });
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id') ?? '';
    this.taskTypeId = parseInt(idParam, 10);
    console.log(this.taskTypeId);
    if (this.taskTypeId !== -1) {
      this.taskForm.get('taskTypeId')?.setValue(this.taskTypeId);
    }
    this.loadTaskFields();
  }

  onSubmit(): void {
    if (this.taskForm.valid) {
      const newTaskDTO: TaskDTO = {
        id: -1,
        name: this.taskForm.value.name,
        description: this.taskForm.value.description,
        dueDate: this.taskForm.value.dueDate,
        taskTypeId: this.taskForm.value.taskTypeId,
        done: false
      };

      this.taskService.addTask(newTaskDTO).subscribe(
        (result: Task) => {
          console.log('Task added:', result);
          this.saveFieldValues(result.id);
          this.location.back()
        },
        (error) => {
          console.error('Error adding task:', error);
        }
      );
    }
  }

  saveFieldValues(taskId: number): void {
    this.filteredTaskFields.map((taskField: TaskField) => {
      const fieldValue: FieldValueDTO = {
        id: -1,
        taskId: taskId,
        taskFieldId: taskField.id,
        field_value: this.taskForm.value[taskField.id.toString()]
      };
      this.fieldValueService.addFieldValue(fieldValue).subscribe((result: FieldValue) => {
        console.log(result)

      })
    });
  }



  loadTaskFields(): void {
    this.taskFieldService.getAllTaskFields().subscribe(
      (response: TaskField[]) => {
        this.taskFields = response;
        this.filteredTaskFields = this.taskFields.filter(
          (taskField) => taskField.taskType.id === this.taskTypeId
        );
        this.filteredTaskFields.forEach((taskField: TaskField) => {
          const validators = [];
          if (taskField.required) {
            validators.push(Validators.required);
          }
          this.taskForm.addControl(taskField.id.toString(), this.formBuilder.control('', Validators.compose(validators)));
        });
      },
      (error) => {
        console.error('Error fetching task fields:', error);
      },
      () => {
        this.taskForm.updateValueAndValidity();
      }
    );
  }



}
