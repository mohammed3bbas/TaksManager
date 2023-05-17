import { TaskTypeDTO } from 'src/app/models/DTOs/task-type-DTO';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TaskType } from 'src/app/models/entities/task-type';

@Injectable({
  providedIn: 'root'
})
export class TaskTypeService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllTaskTypes() : Observable<TaskType[]>{
    return this.http.get<TaskType[]>(`${this.apiServerUrl}/task-types`)
  }

  public addTaskType(taskTypeDTO :TaskTypeDTO){
    return this.http.post<TaskType>(`${this.apiServerUrl}/task-types`,taskTypeDTO)
  }
}
