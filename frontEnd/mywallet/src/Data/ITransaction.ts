import { StatusTransaction } from "../enums/typeStatusTransaction";
import { TypeTransaction } from "../enums/typeTransaction";

export interface ITransactionDTO{
    name: string,
    value:number|null,
    day:Date|undefined|Date[],
    typeTransaction:TypeTransaction|null,
    statusTransaction:StatusTransaction|null,
    description:string,
    isMonthly:boolean
}