export class FieldValueDTO {
    constructor(
        public id: number,
        public taskFieldId: number,
        public taskId: number,
        public field_value: string
    ) { }
}
