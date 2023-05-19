import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskFormComponent } from './components/task-form/task-form.component';
import { TasksComponent } from './components/tasks/tasks/tasks.component';
import { TaskTypeFormComponent } from './components/task-type-form/task-type-form.component';

const routes: Routes = [
  {path: 'new-task/task-type/:id' , component : TaskFormComponent},
  {path: 'new-taskType' , component : TaskTypeFormComponent},
  {path: '**' , component : TasksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
