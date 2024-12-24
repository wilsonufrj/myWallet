import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { IWallet } from "./walletSlice";
import axios from "axios";
import { IDadosMes } from "../../database/mockDadosMes";
import { Ganhos, GastosDebito, Investimentos, ITransacao, ITransacaoGastos } from "../../database/mockDados";

import type { PayloadAction } from '@reduxjs/toolkit'


const initialState: IDadosMes = {

    nomeMes: "Janeiro",
    balanco: {
        ganhosMes: 3800,
        saldoMesSeguinte: 3800,
        saldoInvestimentoMes: 1500,
        saldoAtual: 1300,
        gasto: 1000
    },
    planilhas: {
        gastos: [...GastosDebito],
        investimentos: [...Investimentos],
        ganhos: [...Ganhos]
    }
}



export const homeSlice = createSlice({
    name: "home",
    initialState,
    reducers: {
        adicionarEditarGastos: (state: IDadosMes, action: PayloadAction<ITransacaoGastos>) => {
            const auxGastos = [...state.planilhas.gastos, ];

            let indexTransacao = auxGastos.findIndex((transacao) => transacao.id === action.payload.id);

            if (indexTransacao < 0) {
                auxGastos.push(action.payload)
            } else {
                auxGastos[indexTransacao] = action.payload
    
            }

            const somaGastos = auxGastos.reduce((soma, gasto) => {
                return soma + (gasto.valor ?? 0);
            }, 0);

            return {
                ...state,
                balanco: {
                    ...state.balanco,
                    gasto: somaGastos,
                },
                planilhas: {
                    ...state.planilhas,
                    gastos: auxGastos,
                },
            };
        },
        removerGastos: (state, action: PayloadAction<number[]>) => {
            const auxGastos = state.planilhas
                .gastos.filter(item => !action.payload.includes(item.id))

            const somaGastos = auxGastos.reduce((soma, gasto) => {
                return soma + (gasto.valor ?? 0);
            }, 0);

            return {
                ...state,
                balanco: {
                    ...state.balanco,
                    gasto: somaGastos,
                },
                planilhas: {
                    ...state.planilhas,
                    gastos: auxGastos,
                },
            };
        },
        adicionarInvestimentos: (state, action: PayloadAction<ITransacao>) => {

        },
        removerInvestimentos: (state, action: PayloadAction<number>) => {

        },
        adicionarGanhos: (state, action: PayloadAction<ITransacao>) => {

        },
        removerGanhos: (state, action: PayloadAction<number>) => {

        },
    }
})

export const { adicionarEditarGastos,
    removerGastos
} = homeSlice.actions;

export default homeSlice.reducer;