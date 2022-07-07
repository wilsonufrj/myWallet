import axios from "axios"

const http = 'http://localhost:8080/wallet'

export const loadingData=()=>{
    return{
        type:'LOADING_WALLET'
    }
}

export const sucessWalletData=(data)=>{
    return{
        type:'SUCCESS_WALLET_DATA',
        data
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

export const sucessDeleteWallet = (data)=>{
    return{
        type:'SUCESS_DELETE_WALLET',
        data
    }
}

export const walletGetData = ()=>{
    return dispatch=>{
        dispatch(loadingData())
        axios.get(http+'/5')
        .then(reponse=>{
            dispatch(sucessWalletData(reponse.data));
        })
    }
}


export const getAllWallets = ()=>{
    return dispatch=>{
        dispatch(loadingData())
        axios.get(http)
        .then(response=>{
            dispatch(sucessAllWallets(response.data))
        })
    }
}

export const createWallet = (nameWallet)=>{
    return dispatch=>{
        dispatch(loadingData())
        axios.post(http,{
            name:nameWallet,
            allMoney:0,
            transactions:[]
        })
        .then(response=>{
            dispatch(sucessCreateNewWallet(response.data))
        })
    }
}

export const deleteWallet = (id)=>{
    return dispatch=>{
        dispatch(loadingData())
        axios.delete(http+`/${id}`)
        .then(response =>{
            dispatch(sucessDeleteWallet(response.data))
        })
    }
}