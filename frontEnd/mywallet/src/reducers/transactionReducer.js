// import { Action } from "redux";
// import { ITransactionDTO} from "../Data/ITransaction";

const initialState = {
    name:"Wilson",
    value: 4000,
    day:undefined,
    // typeTransaction:null,
    // statusTransaction:null,
    description:" ",
    loading:false
}

export const transactionReducer = (state = initialState,action)=>{
    switch(action.type){
        case 'ADD_TRANSACTION':{
            return {
                ...state,
                value: state.value + action.value,
                loading:false
            }
        }
        case'LOADING_TRANSACTION':
            {
                return{
                ...state,loading:true
            }
        }    
        default:
            return state;
    }
}