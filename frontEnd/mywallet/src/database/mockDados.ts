import { Nullable } from "primereact/ts-helpers"

export declare interface Transacao {
    id: number,
    data: Date,
    descricao: string,
    banco: string,
    valor: Nullable<number | null>
}
export declare interface TransacaoGasto extends Transacao {
    devedor: string
}
export const Ganhos: Transacao[] = [
    {
        id: 1,
        data: new Date("02/05/2025"),
        descricao: "Salario",
        banco: "Itau",
        valor: 3500
    },
    {
        id: 2,
        data: new Date("02/01/2025"),
        descricao: "Bolsa Faculdade",
        banco: "Banco do Brasil",
        valor: 300
    }
]

export const Investimentos: Transacao[] = [
    {
        id: 1,
        data: new Date("02/15/2025"),
        descricao: "Salario",
        banco: "Nubank",
        valor: 200
    },
    {
        id: 2,
        data: new Date("02/01/2025"),
        descricao: "Bolsa Faculdade",
        banco: "Banco do Brasil",
        valor: 300
    }
]

export const Gastos: TransacaoGasto[] = [
    {
        id: 1,
        data: new Date("02/01/2025"),
        descricao: "Geladeira",
        valor: 400,
        banco: "Nubank",
        devedor: "Wilson"
    },
    {
        id: 2,
        data: new Date("02/01/2025"),
        descricao: "ChatGPT",
        valor: 130,
        banco: "Nubank",
        devedor: "Wilson"
    }, {
        id: 3,
        data: new Date("02/01/2025"),
        descricao: "Academia",
        valor: 120,
        banco: "Nubank",
        devedor: "Wilson"
    }, {
        id: 4,
        data: new Date("02/01/2025"),
        descricao: "Uber voltando pra casa",
        valor: 120,
        banco: "Nubank",
        devedor: "Wilson"
    },
    {
        id: 5,
        data: new Date("02/01/2025"),
        descricao: "Gasto com a casa",
        valor: 2300,
        banco: "Nubank",
        devedor: "Wilson"
    }
]

export const GastosDebito = [
    { id: 1, data: new Date("2025-01-29"), descricao: "Gasto aleatório 1", valor: 375.2, banco: "Nubank", devedor: "Wilson" },
    { id: 2, data: new Date("2025-01-06"), descricao: "Gasto aleatório 2", valor: 45.81, banco: "Nubank", devedor: "Wilson" },
    { id: 3, data: new Date("2025-01-12"), descricao: "Gasto aleatório 3", valor: 241.57, banco: "Nubank", devedor: "Wilson" },
    { id: 4, data: new Date("2025-01-30"), descricao: "Gasto aleatório 4", valor: 328.39, banco: "Nubank", devedor: "Wilson" },
    { id: 5, data: new Date("2025-01-28"), descricao: "Gasto aleatório 5", valor: 391.63, banco: "Nubank", devedor: "Wilson" },
    { id: 6, data: new Date("2025-01-20"), descricao: "Gasto aleatório 6", valor: 159.32, banco: "Nubank", devedor: "Wilson" },
    { id: 7, data: new Date("2025-01-14"), descricao: "Gasto aleatório 7", valor: 228.2, banco: "Nubank", devedor: "Wilson" },
    { id: 8, data: new Date("2025-01-18"), descricao: "Gasto aleatório 8", valor: 51.73, banco: "Nubank", devedor: "Wilson" },
    { id: 9, data: new Date("2025-01-15"), descricao: "Gasto aleatório 9", valor: 346.48, banco: "Nubank", devedor: "Wilson" },
    { id: 10, data: new Date("2025-01-03"), descricao: "Gasto aleatório 10", valor: 154.23, banco: "Nubank", devedor: "Wilson" },
    { id: 11, data: new Date("2025-01-26"), descricao: "Gasto aleatório 11", valor: 310.77, banco: "Nubank", devedor: "Wilson" },
    { id: 12, data: new Date("2025-01-04"), descricao: "Gasto aleatório 12", valor: 44.67, banco: "Nubank", devedor: "Wilson" },
    { id: 13, data: new Date("2025-01-14"), descricao: "Gasto aleatório 13", valor: 213.47, banco: "Nubank", devedor: "Wilson" },
    { id: 14, data: new Date("2025-01-21"), descricao: "Gasto aleatório 14", valor: 177.13, banco: "Nubank", devedor: "Wilson" },
    { id: 15, data: new Date("2025-01-14"), descricao: "Gasto aleatório 15", valor: 39.5, banco: "Nubank", devedor: "Wilson" },
    { id: 16, data: new Date("2025-01-04"), descricao: "Gasto aleatório 16", valor: 208.59, banco: "Nubank", devedor: "Wilson" },
    { id: 17, data: new Date("2025-01-31"), descricao: "Gasto aleatório 17", valor: 109.95, banco: "Nubank", devedor: "Wilson" },
    { id: 18, data: new Date("2025-01-03"), descricao: "Gasto aleatório 18", valor: 215.9, banco: "Nubank", devedor: "Wilson" },
    { id: 19, data: new Date("2025-01-16"), descricao: "Gasto aleatório 19", valor: 155.02, banco: "Nubank", devedor: "Wilson" },
    { id: 20, data: new Date("2025-01-28"), descricao: "Gasto aleatório 20", valor: 133.69, banco: "Nubank", devedor: "Wilson" },
    { id: 21, data: new Date("2025-01-01"), descricao: "Gasto aleatório 21", valor: 285.09, banco: "Nubank", devedor: "Wilson" },
    { id: 22, data: new Date("2025-01-02"), descricao: "Gasto aleatório 22", valor: 259.72, banco: "Nubank", devedor: "Wilson" },
    { id: 23, data: new Date("2025-01-23"), descricao: "Gasto aleatório 23", valor: 346.53, banco: "Nubank", devedor: "Wilson" },
    { id: 24, data: new Date("2025-01-19"), descricao: "Gasto aleatório 24", valor: 29.1, banco: "Nubank", devedor: "Wilson" },
    { id: 25, data: new Date("2025-01-28"), descricao: "Gasto aleatório 25", valor: 316.95, banco: "Nubank", devedor: "Wilson" },
    { id: 26, data: new Date("2025-01-19"), descricao: "Gasto aleatório 26", valor: 358.07, banco: "Nubank", devedor: "Wilson" },
    { id: 27, data: new Date("2025-01-16"), descricao: "Gasto aleatório 27", valor: 244.43, banco: "Nubank", devedor: "Wilson" },
    { id: 28, data: new Date("2025-01-11"), descricao: "Gasto aleatório 28", valor: 85.79, banco: "Nubank", devedor: "Wilson" },
    { id: 29, data: new Date("2025-01-23"), descricao: "Gasto aleatório 29", valor: 238.56, banco: "Nubank", devedor: "Wilson" },
    { id: 30, data: new Date("2025-01-05"), descricao: "Gasto aleatório 30", valor: 190.02, banco: "Nubank", devedor: "Wilson" },
    { id: 31, data: new Date("2025-01-28"), descricao: "Gasto aleatório 31", valor: 85.65, banco: "Nubank", devedor: "Wilson" }
];

