import {gainReducer} from './gainReducer';
import {spendReducer} from './spendReducer';
import { combineReducers } from "redux";

export const Reducers = combineReducers({
    addGain:gainReducer,
    addSpend:spendReducer
})