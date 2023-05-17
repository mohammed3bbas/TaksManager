import { TaskType } from 'src/app/models/entities/task-type';
import { TaskTypeService } from './../../services/task-type/task-type.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss']
})
export class TabsComponent implements OnInit {

  taskTypes: TaskType[] = [];
  @Output() tabSelected: EventEmitter<number> = new EventEmitter<number>();
  activeTabId: number | undefined;

  constructor(private TaskTypeService: TaskTypeService) { }

  ngOnInit(): void {
    this.TaskTypeService.getAllTaskTypes().subscribe((response: TaskType[]) => {
      console.log(response);
      this.taskTypes = response;
    });
  }

  selectTab(value: number): void {
    console.log("tabs");
    this.activeTabId = value;
    this.tabSelected.emit(value);
  }
}