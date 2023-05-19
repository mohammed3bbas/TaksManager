import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TaskDTO } from 'src/app/models/DTOs/task-DTO';
import { Task } from 'src/app/models/entities/task';
import { TaskType } from 'src/app/models/entities/task-type';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiServerUrl = environment.apiBaseUrl + '/tasks';

  constructor(private http: HttpClient) { }

  public getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiServerUrl)

  }
  getTasksByTaskType(taskTypeId: number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiServerUrl}/TaskType/?id=${taskTypeId}`);

  }

  addTask(taskDTO: TaskDTO) {
    return this.http.post<Task>(this.apiServerUrl, taskDTO);
  }

  updateTask(taskDTO: TaskDTO) {
    return this.http.put<Task>(this.apiServerUrl, taskDTO);
  }

  deleteTask(id: number) {
    return this.http.delete<void>(`${this.apiServerUrl}/?id=${id}`);
  }
}
