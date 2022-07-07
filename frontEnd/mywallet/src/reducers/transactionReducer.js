// import { Action } from "redux";
// import { ITransactionDTO} from "../Data/ITransaction";

const initialState = {
    name:"",
    allMoney: 0.0,
    loading:false,
    listTransaction:[]
}

export const transactionReducer = (state = initialState,action)=>{
    switch(action.type){
        case 'ADD_TRANSACTION':{
            return {
                ...state,
                name:action.data.name,
                allMoney:action.data.allMoney,
                listTransaction:[...action.data.transactions],
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