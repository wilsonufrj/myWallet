import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { IWallet } from "./walletSlice";
import axios from "axios";

export interface Wallets{
    wallets:Array<IWallet>
}

const initialState:Wallets = {
    wallets:[]
}

export const getAllWallets = createAsyncThunk(
    'wallet/getAllWallets',
    async ()=>{
        const response = await axios.get("https://localhost:8082/wallet")
        return response.data;
    }
);

export const homeSlice = createSlice({
    name:"home",
    initialState,
    reducers:{},
    extraReducers:(builder)=>{
        builder.addCase(getAllWallets.fulfilled,(state,action)=>{
            state.wallets = action.payload
        })
    }
}) 

export const {} = homeSlice.actions;

export default homeSlice.reducer;