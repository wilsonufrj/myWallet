import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'
import axios from 'axios'

export interface HealthWallet {
    creditLimit: number,
    debitLimit: number,
    closeMonth: number,
    investiment: number
}

export interface IWallet {
    id: number | null
    name: string,
    description: string,
    healthWallet: HealthWallet
}

const initialState: IWallet = {
    id: null,
    name: "",
    description: "",
    healthWallet: {
        creditLimit: 0,
        debitLimit: 0,
        closeMonth: 0,
        investiment: 0
    }
}

export const getWallet = createAsyncThunk(
    'wallet/getWallet',
    async(wallet_id:number|null)=>{
        const response = await axios.get(`https://localhost:8082/walle/${wallet_id}`)
        return response.data;
    }
);

export const walletSlice = createSlice({
    name: "wallet",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(getWallet.fulfilled,(state,action)=>{
            state.id = action.payload.id
            state.name = action.payload.name
            state.description = action.payload.description
            state.healthWallet = action.payload.healthWallet
        })
    }
});

export const { } = walletSlice.actions;

export default walletSlice.reducer;