export class TaskDTO {

    constructor(
        public id: number,
        public name: string,
        public description: string,
        public dueDate: string,
        public taskTypeId: number,
        public done : boolean
    ) { }
}