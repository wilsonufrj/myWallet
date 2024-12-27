import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { IWallet } from "./walletSlice";
import axios from "axios";
import { IDadosMes } from "../../database/mockDadosMes";
import { Ganhos, Gastos, Investimentos, ITransacao, ITransacaoGastos } from "../../database/mockDados";

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
        gastos: [...Gastos],
        investimentos: [...Investimentos],
        ganhos: [...Ganhos]
    }
}



export const homeSlice = createSlice({
    name: "home",
    initialState,
    reducers: {
        adicionarEditarGastos: (state: IDadosMes, action: PayloadAction<ITransacaoGastos>) => {
            const auxGastos = [...state.planilhas.gastos,];

            let indexTransacao = auxGastos.findIndex((transacao) => transacao.id === action.payload.id);

            if (indexTransacao < 0) {
                auxGastos.push(action.payload)
            } else {
                auxGastos[indexTransacao] = action.payload

            }

            const somaGastos = auxGastos.reduce((soma, gasto) => {
                return soma + (gasto.valor ?? 0);
            }, 0);

            const somaInvestimentos = auxGastos.filter(item => item.tipoGasto === "Investimento")
                .reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0)

            return {
                ...state,
                balanco: {
                    ...state.balanco,
                    saldoInvestimentoMes:somaInvestimentos,
                    gasto: somaGastos - somaInvestimentos,
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

            const somaInvestimentos = auxGastos.filter(item => item.tipoGasto === "Investimento")
                .reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0)

            return {
                ...state,
                balanco: {
                    ...state.balanco,
                    saldoInvestimentoMes:somaInvestimentos,
                    gasto: somaGastos - somaInvestimentos
                },
                planilhas: {
                    ...state.planilhas,
                    gastos: auxGastos,
                },
            };
        },
        adicionarEditarGanhos: (state, action: PayloadAction<ITransacao>) => {
            const auxGanhos = [...state.planilhas.ganhos,];

            let indexTransacao = auxGanhos.findIndex((transacao) => transacao.id === action.payload.id);

            if (indexTransacao < 0) {
                auxGanhos.push(action.payload)
            } else {
                auxGanhos[indexTransacao] = action.payload

            }

            const somaGanhos = auxGanhos.reduce((soma, gasto) => {
                return soma + (gasto.valor ?? 0);
            }, 0);

            return {
                ...state,
                balanco: {
                    ...state.balanco,
                    ganhosMes: somaGanhos,
                },
                planilhas: {
                    ...state.planilhas,
                    ganhos: auxGanhos,
                },
            };
        },
        removerGanhos: (state, action: PayloadAction<number[]>) => {
            const auxGanhos = state.planilhas
                .ganhos
                .filter(item => !action.payload.includes(item.id))

            const somaGastos = auxGanhos.reduce((soma, gasto) => {
                return soma + (gasto.valor ?? 0);
            }, 0);

            return {
                ...state,
                balanco: {
                    ...state.balanco,
                    ganhosMes: somaGastos,
                },
                planilhas: {
                    ...state.planilhas,
                    ganhos: auxGanhos,
                },
            };
        },
    }
})

export const { adicionarEditarGastos,
    removerGastos,
    adicionarEditarGanhos,
    removerGanhos
} = homeSlice.actions;

export default homeSlice.reducer;