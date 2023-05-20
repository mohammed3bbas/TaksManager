export class TaskFieldDTO {
    constructor(
        public id: number,
        public name: string,
        public fieldType: string,
        public required: boolean,
        public taskTypeId: number
    ) { }
}
