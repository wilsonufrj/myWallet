import { Action } from "redux";
import { ADD_GAIN } from "../actions/actionTypes";
import { ITransactionDTO} from "../Data/ITransaction";

const initialState:ITransactionDTO = {
    name:"Wilson",
    value: 0,
    day:undefined,
    isMonthly:false,
    typeTransaction:null,
    statusTransaction:null,
    description:" "
}

export const gainReducer = (state:ITransactionDTO = initialState,action:Action<ITransactionDTO>)=>{
    switch(action.type){
        default:
            return state;
    }
}