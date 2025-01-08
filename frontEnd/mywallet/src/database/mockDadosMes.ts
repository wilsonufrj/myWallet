import {
    Ganhos,
    Gastos,
    ITransacao,
    ITransacaoGastos
} from "./mockDados";

export declare interface IBalanco {
    ganhosMes: number
    saldoMesSeguinte: number
    saldoInvestimentoMes: number,
    saldoAtual: number,
    gasto: number
}

export declare interface IPlanilha {
    gastos: ITransacaoGastos[]
    ganhos: ITransacao[]
}
export declare interface IDadosMes {
    nomeMes: string,
    balanco: IBalanco
    planilhas: IPlanilha
}

export const DadosMes: IDadosMes[] = [
    {
        nomeMes: "Janeiro",
        balanco: {
            ganhosMes: Ganhos.reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0),
            saldoMesSeguinte: 3800,
            saldoInvestimentoMes: Gastos.filter(item => item.tipoGasto === "Investimento")
                .reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0),
            saldoAtual: (Ganhos.reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0) - Gastos.reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0)),
            gasto: Gastos.reduce((soma, gasto) => soma + (gasto.valor ?? 0), 0)
        },
        planilhas: {
            gastos: [...Gastos],
            ganhos: [...Ganhos]
        }
    },
    {
        nomeMes: "Fevereiro",
        balanco: {
            ganhosMes: 5900,
            saldoMesSeguinte: 7000,
            saldoInvestimentoMes: 4000,
            saldoAtual: 900,
            gasto: 1000
        },
        planilhas: {
            gastos: [...Gastos],
            ganhos: [...Ganhos]
        }
    }
]