import {applyMiddleware, combineReducers, createStore} from 'redux'
import { transactionReducer } from "../reducers/transactionReducer";
import  thunk  from 'redux-thunk'
import walletReducer from '../reducers/walletReducer';

const rootReducer = combineReducers({
    walletReducer,
    transactionReducer
})

export const store = createStore(rootReducer,applyMiddleware(thunk));