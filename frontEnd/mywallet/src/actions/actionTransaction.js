import axios from "axios";
import { getWalletData, loadMonth } from "./actionMonth";


const httpWallet = 'http://localhost:8082/wallet'
const httpTransaction = 'http://localhost:8082/transaction'


export const loadingSucessTransaction = (data)=>{
    return{
        type:'ADD_TRANSACTION',
        data,
        loading:false
    }
}

export const loadingUpdateTransaction = (data)=>{
    return{
        type:"EDIT_TRANSACTION",
        data,
        loading:false
    }
}

export const loadingDeleteTransaction = (data)=>{
    return{
        type:"DELETE_TRANSACTION",
        data,
        loading:false
    }
}

export const errorTransaction=(error)=>{
    return{
        type:"ERROR",
        value:error,
        loading:false
    }
}

export const loadData =(id)=>{
    return dispatch =>{
        dispatch(loadMonth)
        axios.get(httpWallet+`/${id}`)
                .then((response)=>{
                    dispatch(loadingSucessTransaction(response.data))
                })
    }
}

export const addTransaction = (idWallet,data)=>{
    return dispatch=>{
        
        dispatch(loadMonth)
        axios.post(httpTransaction+`/${idWallet}`,data)
        .then(response=>{
            dispatch(getWalletData(idWallet))
        })
    }
}


export const editTransaction = (id,data,idWallet)=>{
    return dispatch=>{
        dispatch(loadData)
        axios.put(httpTransaction+`/${id}`,data)
        .then(()=>{
            dispatch(getWalletData(idWallet))
        })
    }
}

export const deleteTransaction = (id,idWallet)=>{
    return dispatch =>{
        dispatch(loadMonth)
        axios.delete(httpTransaction+`/${id}`)
        .then(()=>{
            dispatch(getWalletData(idWallet))
        })
    }
}
