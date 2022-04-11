import { IGanho } from "../Data/IGanho"

const initialState = {
    value:0,
    day:undefined,
    description:"",
    isMonthly:false
}

type Action = {type:"ADD_GAIN",payload:string}

export const gainsReducer = (state:IGanho = initialState,action:Action)=>{
    switch(action.type){
        case "ADD_GAIN":{
            return console.log("O estado de post foi chamado");
        }
        default:
            return state;
    }
}