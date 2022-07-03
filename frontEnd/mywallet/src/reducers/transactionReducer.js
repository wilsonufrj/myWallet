// import { Action } from "redux";
// import { ITransactionDTO} from "../Data/ITransaction";

const initialState = {
    name:"Wilson",
    value: 4000,
    day:undefined,
    isMonthly:false,
    typeTransaction:null,
    statusTransaction:null,
    description:" "
}

export const transactionReducer = (state = initialState,action)=>{
    switch(action.type){
        case 'ADD_TRANSACTION':
            return {
                ...state, value: state.value - 300 
            }

        default:
            return state;
    }
}