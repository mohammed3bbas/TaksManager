import { HttpClient , HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
  getTasksByTaskType(taskTypeId : number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiServerUrl}/TaskType/?id=${taskTypeId}`);

  }
}
