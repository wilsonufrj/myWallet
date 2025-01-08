import { Nullable } from "primereact/ts-helpers"

export declare interface ITransacao {
    id: number,
    data: string,
    descricao: string,
    banco: string,
    valor: Nullable<number | null>,
}
export declare interface ITransacaoGastos extends ITransacao {
    responsavel: string
    tipoGasto: string,
    status: string
}
export const Ganhos: ITransacao[] = [
    {
        id: 1,
        data: new Date("02/05/2025").toISOString(),
        descricao: "Salario",
        banco: "Itau",
        valor: 3500
    },
    {
        id: 2,
        data: new Date("02/01/2025").toISOString(),
        descricao: "Bolsa Faculdade",
        banco: "Banco do Brasil",
        valor: 300
    }
]



export const Gastos: ITransacaoGastos[] = [
    { id: 1, status: "Nao_Pago", data: new Date("2025-01-29").toISOString(), descricao: "Gasto aleatório 1", valor: 500.00, banco: "Nubank", responsavel: "Wilson", tipoGasto: "Crédito" },
    { id: 2, status: "Pago", data: new Date("2025-01-06").toISOString(), descricao: "Gasto aleatório 2", valor: 300.00, banco: "Nubank", responsavel: "Wilson", tipoGasto: "Crédito" },
];

