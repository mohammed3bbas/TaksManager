import { Task } from 'src/app/models/entities/task';
import { TaskService } from './../../../services/task/task.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent implements OnInit{

  tasks : Task[] = [];

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.taskService.getAllTasks().subscribe((response: Task[]) => {
      console.log(response);
      this.tasks = response;
    });
  }




}
