import {
    Ganhos,
    GastosDebito,
    Investimentos,
    ITransacao,
    ITransacaoGastos
} from "./mockDados";

export declare interface IBalanco {
    ganhosMes: number
    saldoMesSeguinte: number
    saldoInvestimentoMes: number,
    saldoAtual:number,
    gasto:number
}

export declare interface IPlanilha {
    gastos: ITransacaoGastos[]
    investimentos: ITransacao[]
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
            ganhosMes: 3800,
            saldoMesSeguinte: 3800,
            saldoInvestimentoMes: 1500,
            saldoAtual:1300,
            gasto:1000
        },
        planilhas: {
            gastos: [...GastosDebito],
            investimentos: [...Investimentos],
            ganhos: [...Ganhos]
        }
    },
    {
        nomeMes: "Fevereiro",
        balanco: {
            ganhosMes: 5900,
            saldoMesSeguinte: 7000,
            saldoInvestimentoMes: 4000,
            saldoAtual:900,
            gasto:1000
        },
        planilhas: {
            gastos: [...GastosDebito],
            investimentos: [...Investimentos],
            ganhos: [...Ganhos]
        }
    }
]