import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskFormComponent } from './components/task-form/task-form.component';
import { AppComponent } from './app.component';
import { TasksComponent } from './components/tasks/tasks/tasks.component';

const routes: Routes = [
  {path: 'new-task/task-type/:id' , component : TaskFormComponent},
  {path: '**' , component : TasksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
