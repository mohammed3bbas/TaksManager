import { TaskType } from 'src/app/models/entities/task-type';
import { TaskTypeService } from './../../services/task-type/task-type.service';
import { Component, EventEmitter, OnInit, Output, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class TabsComponent implements OnInit {

  taskTypes: TaskType[] = [];
  @Output() tabSelected: EventEmitter<number> = new EventEmitter<number>();
  @Output() addNewTaskType: EventEmitter<any> = new EventEmitter();
  activeTabId: number = -1;
  isButtonDisabled: boolean = false;

  constructor(private TaskTypeService: TaskTypeService) { }

  ngOnInit(): void {
    this.TaskTypeService.getAllTaskTypes().subscribe((response: TaskType[]) => {
      console.log(response);
      this.taskTypes = response;
      if (this.taskTypes.length > 0) {
        this.activeTabId = this.taskTypes[0].id;
      }
    });
  }

  selectTab(value: number): void {
    console.log("tabs");
    this.activeTabId = value;
    this.tabSelected.emit(value);
  }

  addTaskType(){
    console.log("add task type");
    // this.isButtonDisabled = !this.isButtonDisabled
    // this.activeTabId = -1 ;
    this.addNewTaskType.emit();
  }


  deleteTaskType(){
    this.TaskTypeService.deleteTaskType(this.activeTabId).subscribe(()=>{
      this.ngOnInit();
    });
  }


}