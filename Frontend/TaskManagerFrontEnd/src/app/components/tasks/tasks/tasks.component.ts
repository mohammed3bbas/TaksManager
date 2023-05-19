import { Task } from 'src/app/models/entities/task';
import { TaskService } from './../../../services/task/task.service';
import { Component, ViewChild, ViewEncapsulation } from '@angular/core';
import { TabsComponent } from '../../tabs/tabs.component';
import { Router } from '@angular/router';
import { TaskDTO } from 'src/app/models/DTOs/task-DTO';

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
  completedTasks: Task[] = [];
  @ViewChild(TabsComponent) tabsComponent: TabsComponent | undefined;

  constructor(private taskService: TaskService, private router: Router) { }

  onTabSelected(value: number): void {
    console.log(value);
    this.taskTypeId = value;
    this.fetchTasksAndFilter()

  }

  fetchTasksAndFilter() {
    this.taskService.getAllTasks().subscribe((response: Task[]) => {
      console.log(response);
      this.tasks = response;
      this.filteredTasks = this.tasks.filter(task => task.taskType.id === this.taskTypeId);
      // this.completedTasks = this.tasks.filter(task => task.taskType.id === this.taskTypeId && task.done === true);
    });
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

  updateCheckedTasks(event: any, taskId: number): void {
    console.log(taskId);
    if (event) {
      const checkedTask = this.tasks.find(task => task.id === taskId);
      if (checkedTask) {
        const newTaskDTO: TaskDTO = {
          id: checkedTask.id,
          name: checkedTask.name,
          description: checkedTask.description,
          dueDate: checkedTask.dueDate.toString(),
          taskTypeId: checkedTask.taskType.id,
          done: !checkedTask.done
        }
        this.taskService.updateTask(newTaskDTO).subscribe((result: Task) => {
          this.fetchTasksAndFilter();
        },
          (error) => {
            console.error('Error updating task:', error);
          });;
      }
    }
  }
}
