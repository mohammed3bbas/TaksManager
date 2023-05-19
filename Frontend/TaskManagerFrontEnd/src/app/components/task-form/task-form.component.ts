import { TaskService } from './../../services/task/task.service';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskDTO } from 'src/app/models/DTOs/task-DTO';
import { Task } from 'src/app/models/entities/task';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent implements OnInit {
  taskForm: FormGroup;
  taskTypeId: number = -1;

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private taskService: TaskService , private router: Router) {
    this.taskForm = this.formBuilder.group({
      name: ['', Validators.required],
      description : [''] ,
      dueDate : ['', Validators.required],
      taskTypeId : []

    });
  }
  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id') ?? '';
    this.taskTypeId = parseInt(idParam, 10);
    console.log(this.taskTypeId);
    if (this.taskTypeId !== -1) {
      this.taskForm.get('taskTypeId')?.setValue(this.taskTypeId);
    }
  }

  onSubmit(): void {
    console.log(this.taskForm.value.name);
    if (this.taskForm.valid) {
      const newTaskDTO: TaskDTO = {
        id: -1,
        name: this.taskForm.value.name,
        description: this.taskForm.value.description,
        dueDate: this.taskForm.value.dueDate,
        taskTypeId: this.taskForm.value.taskTypeId
      };

      this.taskService.addTask(newTaskDTO).subscribe(
        (result: Task) => {
          console.log('Task added:', result);
          this.router.navigate(['']);
        },
        (error) => {
          console.error('Error adding task:', error);
      });


    }
  }
}
