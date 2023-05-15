import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { HttpClient } from '@angular/common/http';
import { TaskType } from '../models/entities/task-type';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskTypeService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllTaskTypes() : Observable<TaskType[]>{
    return this.http.get<TaskType[]>(`${this.apiServerUrl}/task-types`)
    
  }
}
