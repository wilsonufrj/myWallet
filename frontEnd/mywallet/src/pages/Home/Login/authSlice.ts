import axios from "axios";
import {
    createSlice,
    PayloadAction,
    createAsyncThunk
} from "@reduxjs/toolkit";
import { Usuario } from "../../../Domain/Usuario";

const API_URL = "http://localhost:8082";


export interface AuthState {
    isAuthenticated: boolean;
    idUsuario: number;
}

const initialState: AuthState = {
    isAuthenticated: false,
    idUsuario: 0,
};


export const loginUser = createAsyncThunk(
    "auth/loginUser",
    async ({ nome, senha }: { nome: string; senha: string }) => {

        const responseToken = await axios.post(
            `${API_URL}/api/usuario/login`,
            { nome, senha },
        );

        return responseToken.data.id;
    }
);


const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        logout: (state) => {
            state.isAuthenticated = false;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(loginUser.fulfilled, (state, action: PayloadAction<number>) => {
                state.isAuthenticated = true;
                state.idUsuario = action.payload;
            })
            .addCase(loginUser.rejected, (state, action) => {
                console.error("Erro de login:", action.payload);
            });
    }
});

export const { logout } = authSlice.actions;
export default authSlice.reducer;
