import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TaskField } from 'src/app/models/entities/task-field';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root'
})
export class TaskFieldService {
  private apiServerUrl = environment.apiBaseUrl + '/task-field';
  constructor(private http: HttpClient) { }

  public getAllTaskFields(): Observable<TaskField[]> {
    return this.http.get<TaskField[]>(`${this.apiServerUrl}`)
  }

}
