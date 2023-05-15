import { TaskField } from './task-field';
import {Task} from './task'

export interface FieldValue {
    id: number;
    taskField: TaskField;
    task: Task;
    fieldValue: string;
}