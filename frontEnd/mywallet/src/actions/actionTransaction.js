import axios from "axios";

const http = 'http://localhost:8080/wallet'

export const loadingData = ()=>{
    return{
        type:'LOADING_TRANSACTION',
        loading:true
    }
}

export const loadingSucessTransaction = (data)=>{
    return{
        type:'ADD_TRANSACTION',
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
        dispatch(loadingData)
        axios.get(http+`/${id}`)
                .then((response)=>{
                    dispatch(loadingSucessTransaction(response.data))
                })
    }
}

export const addTransaction = (id,data)=>{
    return dispatch=>{
        dispatch(loadingData)
        axios.post(http+`/transaction/${id}`,data)
        .then(response=>{
            dispatch(loadingSucessTransaction(response.data))
        })
    }
}

