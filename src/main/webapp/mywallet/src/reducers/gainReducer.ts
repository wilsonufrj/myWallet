import { Action } from "redux";
import { ADD_GAIN } from "../actions/actionTypes";
import { IGanho } from "../Data/IGanho";

const initialState:IGanho = {
    name:"Wilson",
    value: 0,
    day:undefined,
    isMonthly:false,
    description:" "
}

export const gainReducer = (state:IGanho = initialState,action:Action<IGanho>)=>{
    switch(action.type){
        default:
            return state;
    }
}