import { TaskType } from 'src/app/models/entities/task-type';
import { TaskTypeService } from './../../services/task-type.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss']
})
export class TabsComponent implements OnInit {

  taskTypes: TaskType[] =[];

  constructor(private TaskTypeService: TaskTypeService) { }

  ngOnInit(): void {
    this.TaskTypeService.getAllTaskTypes().subscribe((response: TaskType[]) => {
      console.log(response);
      this.taskTypes = response;
    });
  }

}
