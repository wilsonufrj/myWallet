import Footer from "../components/footer/App";
import "./style.css";

import { Chart } from 'primereact/chart';
import { Button } from 'primereact/button';
import { Link } from "react-router-dom";

function Home() {

    const chartData = {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July','August','September','October','November','December'],
        datasets: [{
            type: 'line',
            label: 'Dataset 1',
            borderColor: '#42A5F5',
            borderWidth: 2,
            fill: false,
            tension: .4,
            data: [
                50,
                25,
                12,
                48,
                56,
                76,
                42
            ]
        }, {
            type: 'bar',
            label: 'Dataset 2',
            backgroundColor: '#66BB6A',
            data: [
                21,
                84,
                24,
                75,
                37,
                65,
                34
            ],
            borderColor: 'white',
            borderWidth: 2
        }, {
            type: 'bar',
            label: 'Dataset 3',
            backgroundColor: '#FFA726',
            data: [
                41,
                52,
                24,
                74,
                23,
                21,
                32
            ]
        }]
    };

    const lightOptions = {
        maintainAspectRatio: false,
        aspectRatio: .6,
        plugins: {
            legend: {
                labels: {
                    color: '#495057'
                }
            }
        },
        scales: {
            x: {
                ticks: {
                    color: '#495057'
                },
                grid: {
                    color: '#ebedef'
                }
            },
            y: {
                ticks: {
                    color: '#495057'
                },
                grid: {
                    color: '#ebedef'
                }
            }
        }
    };

    return(
        <div>
            <h1 className="title">Bem vindo ao myWallet</h1>
            <div className="mainContainer">
                <h2>Histórico Financeiro</h2>
                    <div className="card">
                        <Chart type="bar" data={chartData} options={lightOptions} />
                    </div>
                
                <div className="adicionar">
                    <div>
                        <h2>Adicionar Ganhos</h2>
                        <Link style={{textDecorationLine:'none'}} to={"/adding"}>
                            <Button icon='pi pi-plus' className='p-button-success'/>
                        </Link>
                        
                        
                    </div>
                    <div>
                        <h2>Adicionar Gastos</h2>
                        <Button icon='pi pi-times' className='p-button-danger'/>
                    </div>
                    <div>
                        <h2>Ver gastos do mês</h2>
                        <Button icon='pi pi-search' className='p-button-info'/>
                    </div>
                    <div>
                        <h2>Ver ganhos dos mês</h2>
                        <Button icon='pi pi-search' className='p-button-info'/>
                    </div>
                </div>
                
                

            </div>
            
            
            <Footer/>
        </div>
    )
}

export default Home;