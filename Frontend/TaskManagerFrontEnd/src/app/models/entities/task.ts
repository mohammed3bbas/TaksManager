import { TaskType } from './task-type';
export interface Task {
    id: number;
    name: string;
    description: string;
    dueDate: Date;
    creationDate: Date;
    taskType: TaskType;
    done : boolean;
}