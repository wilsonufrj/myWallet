import { StatusTransaction } from "../enums/typeStatusTransaction";
import { TypesTransaction } from "../enums/typeTransaction";

export interface ITransactionDTO{
    name: string,
    value:number|null,
    day:Date|undefined|Date[],
    typeTransaction:TypesTransaction|null,
    statusTransaction:StatusTransaction|null,
    description:string,
    isMonthly:boolean
}