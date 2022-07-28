import axios from "axios"

const httpWallet = 'http://localhost:8080/wallet'

export const loadMonth = ()=>{
    return{
        type:"LOADING_MONTH",
    }
}

export const successDataWallet = (data)=>{
    
    return{
        type:'SUCCESS_DATA_WALLET',
        name:data.name,
        payload:data
    }
}

export const erroDataWallet = (error)=>{
    return{
        type:"ERRO_DATA_WALLET",
        error:error
    }
}

export const getWalletData = (idWallet) =>{
    return dispatch =>{
        dispatch(loadMonth)
        axios.get(httpWallet + `/${idWallet}`)
        .then(response=>{
            dispatch(successDataWallet(response.data))
        })
        .catch(e =>{
            dispatch(erroDataWallet(e))
        })
    }
}