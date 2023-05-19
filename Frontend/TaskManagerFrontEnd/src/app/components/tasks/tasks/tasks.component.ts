import { Task } from 'src/app/models/entities/task';
import { TaskService } from './../../../services/task/task.service';
import { Component, EventEmitter, Output, ViewChild, ViewEncapsulation } from '@angular/core';
import { TabsComponent } from '../../tabs/tabs.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class TasksComponent {

  tasks: Task[] = [];
  taskTypeId: number = 0;
  filteredTasks: Task[] = [];
  addNewTaskTypeMode: boolean = false;
  @Output() refetchTabs: EventEmitter<void> = new EventEmitter<void>();
  @ViewChild(TabsComponent) tabsComponent: TabsComponent | undefined;

  constructor(private taskService: TaskService, private router: Router) { }

  onTabSelected(value: number): void {
    console.log(value);
    this.taskTypeId = value;
    this.taskService.getAllTasks().subscribe((response: Task[]) => {
      console.log(response);
      this.tasks = response;
      this.filteredTasks = this.tasks.filter(task => task.taskType.id === this.taskTypeId);
    });
  }

  switchAddNewTaskTypeMode() {
    this.addNewTaskTypeMode = !this.addNewTaskTypeMode;
  }

  onAddNewTaskType(): void {
    console.log("we are here")
    if (this.tabsComponent) {
      this.tabsComponent.ngOnInit();
    }
  }

  openNewTaskForm() {
    this.router.navigate(['/new-task/task-type/', this.taskTypeId]);

  }
}
