import axios from "axios";

const http = 'http://localhost:8080/transaction'

export const loadingData = ()=>{
    return{
        type:'LOADING_TRANSACTION',
        loading:true
    }
}

export const loadingSucessTransaction = (data)=>{
    return{
        type:'ADD_TRANSACTION',
        value:  data.value,
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

export const loadData =()=>{
    return dispatch =>{
        dispatch(loadingData)
        axios.get(http)
                .then((response)=>{
                    dispatch(loadingSucessTransaction(response.data))
                })
    }
}

export const addTransaction = (data)=>{
    return dispatch=>{
        dispatch(loadingData)
        axios.post(http,data)
        .then(response=>{
            dispatch(loadingSucessTransaction(response.data))
        })
    }
}

