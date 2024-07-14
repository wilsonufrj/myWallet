import axios from "axios"

const http = 'http://localhost:8082/wallet'

export const loadingWallet=()=>{
    return{
        type:'LOADING_WALLET'
    }
}


export const sucessAllWallets = (data)=>{
    return{
        type:'SUCESS_ALL_WALLETS',
        data
    }
}

export const sucessCreateNewWallet = (data)=>{
    return{
        type:'SUCESS_CREATE_WALLET',
        data
    }
} 

export const getAllWallets = ()=>{
    return dispatch=>{
        dispatch(loadingWallet)
        axios.get(http)
        .then(response=>{
            dispatch(sucessAllWallets(response.data))
        })
    }
}

export const createWallet = (data)=>{
    return dispatch=>{
        dispatch(loadingWallet)
        axios.post(http,data)
        .then(response=>{
            dispatch(sucessCreateNewWallet(response.data))
        })
    }
}

export const deleteWallet = (id)=>{
    return dispatch=>{
        dispatch(loadingWallet)
        axios.delete(http+`/${id}`)
        .then(response =>{
            dispatch(getAllWallets())
        })
    }
}