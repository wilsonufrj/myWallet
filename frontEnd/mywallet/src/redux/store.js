import {createStore} from 'redux'
import { transactionReducer } from "../reducers/transactionReducer";


export const store = createStore(transactionReducer);