const initialState = {
    name:"",
    allMoney: 0.0,
    loading:false,
    listTransaction:[]
}

const monthReducer = (state = initialState,action)=>{
    switch(action.type){
        case 'SUCCESS_DATA_WALLET':
            return{
                ...state,
                name:action.name,
                allMoney:action.payload.allMoney,
                listTransaction:action.payload.transactions,
                loading:false,
                
            }
        
        case'LOADING_MONTH': 
            return{
                ...state,
                loading:true
        }

        case 'DELETE_TRANSACTION':
        case 'EDIT_TRANSACTION':
        case 'ADD_TRANSACTION':
            return{
                ...state,
                allMoney:action.data.allMoney,
                listTransaction:action.data.transactions
            }

        default:
            return state;
    }
}

export default monthReducer;