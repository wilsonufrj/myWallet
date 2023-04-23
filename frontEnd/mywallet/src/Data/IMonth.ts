import { ITransactionDTO } from "./ITransaction";

export interface IMonthDTO{
    name:String,
    description:String,
    transactions:Array<ITransactionDTO>
}
