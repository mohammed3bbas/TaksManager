import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FieldValue } from 'src/app/models/entities/field-value';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root'
})
export class FieldValueService {
  private apiServerUrl = environment.apiBaseUrl + '/field-value';

  constructor(private http: HttpClient) { }

  public getAllFieldValues(): Observable<FieldValue[]> {
    return this.http.get<FieldValue[]>(`${this.apiServerUrl}`)
  }
}
