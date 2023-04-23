
const inicial_state = {
    listWallet:[],
    loading:false,
}

 const walletReducer = (state = inicial_state,action)=>{
    switch(action.type){
        case('LOADING_WALLET'):
            return{
                ...state,
                loading:true
            }
            
        case('SUCESS_ALL_WALLETS'):
            return{
                ...state,
                listWallet:action.data,
                loading:false
            }

        case('SUCESS_CREATE_WALLET'):
            return{
                ...state,
                loading:false,
                listWallet:[...state.listWallet,action.data]
            }
        default:
            return state;
    }
    
}

export default walletReducer;