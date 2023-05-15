import { TaskType } from "./task-type";

export interface TaskField {
    id: number;
    name: string;
    fieldType: string;
    isRequired: boolean;
    taskType: TaskType;
}