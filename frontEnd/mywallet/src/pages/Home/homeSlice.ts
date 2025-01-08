import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { IBalanco, IDadosMes } from "../../database/mockDadosMes";
import { Ganhos, Gastos, ITransacao, ITransacaoGastos } from "../../database/mockDados";

import type { PayloadAction } from '@reduxjs/toolkit'

const somaValor = (lista: ITransacao[]) => {
    return lista.reduce((total: number, transacao) => total + (transacao.valor ?? 0), 0);
}

const somaValorGastos = (lista: ITransacaoGastos[], filtro: string, pago?: boolean) => {
    if (pago) {
        return lista
            .filter(item => item.tipoGasto === filtro)
            .filter(item => item.responsavel === "Wilson")
            .filter(item => item.status !== "Pago")
            .reduce((total: number, transacao) => total + (transacao.valor ?? 0), 0);
    }
    if (pago === false) {
        return lista
            .filter(item => item.tipoGasto === filtro)
            .filter(item => item.responsavel === "Wilson")
            .filter(item => item.status === "Pago")
            .reduce((total: number, transacao) => total + (transacao.valor ?? 0), 0);
    }

    return lista
        .filter(item => item.tipoGasto === filtro)
        .filter(item => item.responsavel === "Wilson")
        .reduce((total: number, transacao) => total + (transacao.valor ?? 0), 0);
}

const atualizaBalanco = (estadoAtual: IDadosMes,
    listaGanhos: ITransacao[],
    listaGastos: ITransacaoGastos[]): IBalanco => {

    let auxBalanco = { ...estadoAtual.balanco }

    let somaGanhos = somaValor(listaGanhos);
    let somaDebito = somaValorGastos(listaGastos, "Debito");
    let somaCreditoNaoPagos = somaValorGastos(listaGastos, "Crédito", true);
    let somaCreditosPagos = somaValorGastos(listaGastos, "Crédito", false);
    let somaInvestimento = somaValorGastos(listaGastos, "Investimento");

    auxBalanco.saldoAtual = somaGanhos - somaInvestimento - somaDebito - somaCreditosPagos;
    auxBalanco.saldoInvestimentoMes = somaInvestimento
    auxBalanco.saldoMesSeguinte = somaGanhos - somaCreditoNaoPagos
    auxBalanco.gasto = somaDebito + somaCreditoNaoPagos + somaInvestimento
    auxBalanco.ganhosMes = somaGanhos


    return auxBalanco;
}

const initialState: IDadosMes = {

    nomeMes: "Janeiro",
    balanco: atualizaBalanco({} as IDadosMes, Ganhos, Gastos),
    planilhas: {
        gastos: [...Gastos],
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

            return {
                ...state,
                balanco: atualizaBalanco(state, state.planilhas.ganhos, auxGastos),
                planilhas: {
                    ...state.planilhas,
                    gastos: auxGastos,
                },
            };
        },
        removerGastos: (state, action: PayloadAction<number[]>) => {
            const auxGastos = state.planilhas
                .gastos.filter(item => !action.payload.includes(item.id))

            return {
                ...state,
                balanco: atualizaBalanco(state, state.planilhas.ganhos, auxGastos),
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


            return {
                ...state,
                balanco: atualizaBalanco(state, auxGanhos, state.planilhas.gastos),
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

            return {
                ...state,
                balanco: atualizaBalanco(state, auxGanhos, state.planilhas.gastos),
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