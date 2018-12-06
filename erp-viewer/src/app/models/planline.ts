import {Plan} from './plan';
export class PlanLine {
    label:string;
    code:number;
    levelName:string;
    previous:PlanLine;
    plan:Plan;

}