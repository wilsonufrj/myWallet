import { createSlice, PayloadAction, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';
import { RootState } from '../../../redux/store';
import { Carteira } from '../../../Domain/Carteira';


export interface CarteirasUsuarioState {
    carteiras: Carteira[]
}

const initialState: CarteirasUsuarioState = {
    carteiras: []
};


export const fetchCarteiras = createAsyncThunk(
    'carteira/fetchCarteiras',
    async (_, { getState }) => {

        const state = getState() as RootState;
        const idUsuario: number = state.auth.idUsuario;

        const response = await axios.get(`http://localhost:8082/api/carteira/${idUsuario}`);
        return response.data;
    }
);

export const criarCarteira = createAsyncThunk(
    'carteira/criarCarteira',
    async (carteira: Carteira, { getState }) => {

        const state = getState() as RootState;
        const idUsuario: number = state.auth.idUsuario;

        const response = await axios.post(`http://localhost:8082/api/carteira/${idUsuario}`,
            carteira,
        );

        return response.data;
    }
);

const carteiraSlice = createSlice({
    name: 'carteira',
    initialState,
    reducers: {
        deletarCarteira: (state, action: PayloadAction<number>) => {
            state.carteiras = state.carteiras.filter(carteira => carteira.id !== action.payload);
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchCarteiras.fulfilled, (state, action: PayloadAction<any>) => {
            state.carteiras = action.payload;
        });
        builder.addCase(criarCarteira.fulfilled, (state, action: PayloadAction<Carteira>) => {
            state.carteiras.push(action.payload);
        }
        );
    }
});

export const { deletarCarteira } = carteiraSlice.actions;
export default carteiraSlice.reducer;