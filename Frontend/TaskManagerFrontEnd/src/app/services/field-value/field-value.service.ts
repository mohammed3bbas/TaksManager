import { FieldValueDTO } from './../../models/DTOs/field-value-DTO';
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

  public addFieldValue(fieldValueDTO : FieldValueDTO) {
    return this.http.post<FieldValue>(`${this.apiServerUrl}` , fieldValueDTO);
  }

  public updateFieldValue(fieldValueDTO : FieldValueDTO) {
    return this.http.put<FieldValue>(`${this.apiServerUrl}` , fieldValueDTO);
  }
}
