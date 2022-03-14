import { ADD_GAIN } from "../actions/actionTypes";
const initialState = {
    valorTotal:0,
}

export const gainReducer = (state = initialState,action)=>{
    switch(action.type){
        case ADD_GAIN:
            return{
                ...state,
                valorTotal:action.novoTotal
            }
        default:
            return state;
    }
}