import { Card } from "primereact/card";
import React, { useEffect, useState } from "react";
import { Ganhos, Gastos, GastosDebito, Investimentos, Transacao} from "../../database/mockDados";
import { Chart } from 'primereact/chart';
import DataTableGanhos from "../../components/DataTableGanhos";
import DataTableGastos from "../../components/DataTableGastos";
import { TabPanel, TabView } from "primereact/tabview";



const Home = () => {

    const [dadosGanhos, setDadosGanhos] = useState(Ganhos);
    const [dadosGastos, setDadosGastos] = useState(Gastos);
    const [dadosInvestimento, setDadosInvestimento] = useState(Investimentos)
    const [dadosGastosDebito, setDadosGastosDebito] = useState(GastosDebito)


    const [chartData, setChartData] = useState({});
    const [chartOptions, setChartOptions] = useState({});

    const ganhos = [3500, 300, ...Array(28).fill(0)];
    const somaValor = (lista: Transacao[]) => {
        let valorTotal: number = 0;
        lista.forEach(transacao => {
            if (transacao?.valor)
                valorTotal += transacao.valor
        });
        return valorTotal;
    }

    let handleDataGrafico = (dados:Transacao[])=>{
        let valores:any=[]
        dados.forEach(item=>{
            valores.push(item.valor)
        })

        return valores;
    }

    useEffect(() => {
        const documentStyle = getComputedStyle(document.documentElement);
        const textColor = documentStyle.getPropertyValue('--text-color');
        const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
        const surfaceBorder = documentStyle.getPropertyValue('--surface-border');
        const data = {
            labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30','31'],
            datasets: [
                {
                    label: 'Gastos Débito',
                    data: handleDataGrafico(dadosGastosDebito),
                    fill: false,
                    borderColor: documentStyle.getPropertyValue('--blue-500'),
                    tension: 0.4
                },
                {
                    label: 'Ganhos',
                    data: ganhos,
                    fill: false,
                    borderColor: documentStyle.getPropertyValue('--pink-500'),
                    tension: 0.4
                }
                // {
                //     label: 'Passar o mês',
                //     data: [3266.8, 3170.62, 2780.05, 2671.36, 2491.15, 2377.42, 2137.77, 1888.25, 1734.13, 1651.83, 1281.14, 1119.81, 981.79, 823.79, 601.87, 471.32, 359.16, 319.66, 268.51, 12.19, -196.59, -435.46, -435.47, -651.26, -742.18, -969.66, -1316.0, -1317.04, -1708.09, -1782.41],
                //     fill: false,
                //     borderColor: documentStyle.getPropertyValue('--green-500'),
                //     tension: 0.4
                // }

            ]
        };
        const options = {
            maintainAspectRatio: false,
            aspectRatio: 0.6,
            plugins: {
                legend: {
                    labels: {
                        color: textColor
                    }
                }
            },
            scales: {
                x: {
                    ticks: {
                        color: textColorSecondary
                    },
                    grid: {
                        color: surfaceBorder
                    }
                },
                y: {
                    ticks: {
                        color: textColorSecondary
                    },
                    grid: {
                        color: surfaceBorder
                    }
                }
            }
        };

        setChartData(data);
        setChartOptions(options);
    }, []);

    const formatCurrency = (value: number) => {
        return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    };


    return (
        <div className="p-4">
            <div id="Title">
                <div className="flex justify-content-center font-bold text-5xl m-5">
                    <span>Janeiro</span>
                </div>
                <TabView>
                    <TabPanel header="Balanço" leftIcon="pi pi-calculator m-2">
                        <div className="card">
                            <Chart type="bar" data={chartData} options={chartOptions} />
                            <div className="flex justify-content-around">
                                <Card title="Ganhos do mês" className="ml-2">
                                    <span className="flex align-items-center justify-content-center text-4xl font-bold">
                                        {formatCurrency(somaValor(dadosGanhos))}
                                    </span>
                                </Card>
                                <Card title="Passar o mês seguinte" className="ml-2">
                                    <span className="flex align-items-center justify-content-center text-4xl font-bold">
                                        {formatCurrency(somaValor(dadosGanhos) - somaValor(dadosGastos))}
                                    </span>
                                </Card>
                                <Card title="Sobrou para o mês" className="ml-2">
                                    <span className="flex align-items-center justify-content-center text-4xl font-bold">
                                        {formatCurrency(somaValor(dadosGanhos)-somaValor(dadosGastos)-somaValor(dadosInvestimento))}
                                    </span>
                                </Card>
                                <Card title="Gastos Débito" className="ml-2">
                                    <span className="flex align-items-center justify-content-center text-4xl font-bold">
                                        {formatCurrency(somaValor(GastosDebito))}
                                    </span>
                                </Card>
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Planilhas" leftIcon="pi pi-money-bill m-2">
                        <div className="grid">
                            <DataTableGanhos titulo="Ganhos" transacoes={dadosGanhos} updateTransacoes={setDadosGanhos} />
                            <DataTableGastos titulo="Cartão de Crédito" transacoes={dadosGastos} updateTransacoes={setDadosGastos} />
                            <DataTableGanhos titulo="Investimento" transacoes={dadosInvestimento} updateTransacoes={setDadosInvestimento} />
                            <DataTableGastos titulo="Gastos Débito" transacoes={dadosGastosDebito} updateTransacoes={setDadosGastosDebito} />
                        </div>
                    </TabPanel>
                </TabView>
            </div>
        </div>
    )
}

export default Home;