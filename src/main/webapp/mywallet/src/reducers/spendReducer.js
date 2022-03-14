import { ADD_SPEND } from "../actions/actionTypes";

const initialState={
    spend:0
}

export const spendReducer = (state = initialState,action)=>{
    switch(action.type){
        case ADD_SPEND:
            return{
                ...state,
                spend:action.newSpend
            }
        default:
            return state;
    }
}