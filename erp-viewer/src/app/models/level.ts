import { LevelType} from './levelType';
export class Level {

    id:string;
    label:string;
    level:LevelType;
    previous:Level;
    code:number;
    
  }