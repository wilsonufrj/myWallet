import React, { useEffect, useState } from "react";
import { ITransacao,Gastos } from "../database/mockDados";
import { Chart } from "primereact/chart";

const BarChart = () => {

    const [chartData, setChartData] = useState({});
    const [chartOptions, setChartOptions] = useState({});
    const [dadosGastos, setDadosGastos] = useState(Gastos)

    const ganhos = [3500, 300, ...Array(28).fill(0)];

    useEffect(() => {
        const documentStyle = getComputedStyle(document.documentElement);
        const textColor = documentStyle.getPropertyValue('--text-color');
        const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
        const surfaceBorder = documentStyle.getPropertyValue('--surface-border');
        const data = {
            labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'],
            datasets: [
                {
                    label: 'Gastos Débito',
                    data: handleDataGrafico(dadosGastos),
                    fill: false,
                    backgroundColor: documentStyle.getPropertyValue('--blue-500'),
                    borderColor: documentStyle.getPropertyValue('--blue-500'),
                    tension: 0.4
                },
                {
                    label: 'Gasto Crédito',
                    data: ganhos,
                    fill: false,
                    backgroundColor: documentStyle.getPropertyValue('--pink-500'),
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
            aspectRatio: 0.8,
            plugins: {
                legend: {
                    labels: {
                        fontColor: textColor
                    }
                }
            },
            scales: {
                x: {
                    ticks: {
                        color: textColorSecondary,
                        font: {
                            weight: 500
                        }
                    },
                    grid: {
                        display: false,
                        drawBorder: false
                    }
                },
                y: {
                    ticks: {
                        color: textColorSecondary
                    },
                    grid: {
                        color: surfaceBorder,
                        drawBorder: false
                    }
                }
            }
        };

        setChartData(data);
        setChartOptions(options);
    }, []);

    let handleDataGrafico = (dados: ITransacao[]) => {
        let valores: any = []
        dados.forEach(item => {
            valores.push(item.valor)
        })

        return valores;
    }

    return (
        <Chart type="bar" data={chartData} options={chartOptions} className="w-full h-full" />
    )
}

export default BarChart;