import {applyMiddleware, combineReducers, createStore} from 'redux'
import  monthReducer from "../reducers/monthReducer";
import  thunk  from 'redux-thunk'
import walletReducer from '../reducers/walletReducer';

const rootReducer = combineReducers({
    walletReducer,
    monthReducer
})

export const store = createStore(rootReducer,applyMiddleware(thunk));