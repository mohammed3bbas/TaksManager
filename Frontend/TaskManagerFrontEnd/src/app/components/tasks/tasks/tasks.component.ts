import { FieldValue } from './../../../models/entities/field-value';
import { FieldValueService } from './../../../services/field-value/field-value.service';
import { TaskField } from './../../../models/entities/task-field';
import { Task } from 'src/app/models/entities/task';
import { TaskService } from './../../../services/task/task.service';
import { TaskFieldService } from './../../../services/task-field/task-field.service';
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
  taskFields: TaskField[] = [];
  filteredFieldValues: FieldValue[] = [];
  FieldValues: FieldValue[] = [];
  filteredTaskFields: TaskField[] = [];
  @ViewChild(TabsComponent) tabsComponent: TabsComponent | undefined;

  constructor(
    private taskService: TaskService,
    private taskFieldService: TaskFieldService,
    private fieldValueService: FieldValueService,
    private router: Router) { }

  onTabSelected(value: number): void {
    console.log(value);
    this.taskTypeId = value;
    this.fetchTasksAndFilter();
    this.fetchTaskFields();
    this.fetchFieldValues()
  }

  fetchTaskFields() {
    this.taskFieldService.getAllTaskFields().subscribe((response: TaskField[]) => {
      this.taskFields = response;
      this.filteredTaskFields = this.taskFields.filter(taskField => taskField.taskType.id === this.taskTypeId);
    });
  }

  fetchTasksAndFilter() {
    this.taskService.getAllTasks().subscribe((response: Task[]) => {
      // console.log(response);
      this.tasks = response;
      this.filteredTasks = this.tasks.filter(task => task.taskType.id === this.taskTypeId);
    });
  }

  fetchFieldValues() {
    this.fieldValueService.getAllFieldValues().subscribe((response: FieldValue[]) => {
      console.log(response);
      this.FieldValues = response;
      this.filteredFieldValues = this.FieldValues.filter(fieldValue => fieldValue.task.taskType.id === this.taskTypeId);
      console.log(this.filteredFieldValues)
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

  deleteTask(event: any, taskId: number): void {

    if (event) {
      this.taskService.deleteTask(taskId).subscribe(
        () => {
          this.fetchTasksAndFilter();

        },
        (error) => {
          console.error('Error deleting task :', error);
        }
      );
    }
  }

  hasFieldValue(taskId: number, fieldId: number): boolean {
    return this.filteredFieldValues.some(
      (fieldValue) => fieldValue.task.id === taskId && fieldValue.taskField.id === fieldId
    );
  }
  
  getFieldValue(taskId: number, fieldId: number): string {
    const fieldValue = this.filteredFieldValues.find(
      (fieldValue) => fieldValue.task.id === taskId && fieldValue.taskField.id === fieldId
    );
    return fieldValue ? fieldValue.field_value : '';
  }
  
}
