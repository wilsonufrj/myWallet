import {applyMiddleware, createStore} from 'redux'
import { transactionReducer } from "../reducers/transactionReducer";
import  thunk  from 'redux-thunk'
import walletReducer from '../reducers/walletReducer';


export const store = createStore(walletReducer,applyMiddleware(thunk));