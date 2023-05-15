export class TaskFieldDTO {
    constructor(
        public id: number,
        public name: string,
        public fieldType: string,
        public isRequired: boolean,
        public taskTypeId: number
    ) { }
}
