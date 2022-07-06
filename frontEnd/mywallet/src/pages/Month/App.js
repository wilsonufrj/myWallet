import React, { useEffect, useState } from 'react';
import { Button } from 'primereact/button';
import { Link, useLocation} from 'react-router-dom';
import "./style.css";
import { Card } from 'primereact/card';
import { Chart } from 'primereact/chart';

import DataTableDemo from '../components/DataList/App';

import { InputNumber } from 'primereact/inputnumber';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { InputSwitch } from 'primereact/inputswitch';

import { Dropdown } from 'primereact/dropdown';

import { StatusTransaction } from '../../enums/typeStatusTransaction';
import { TypeTransaction } from '../../enums/typeTransaction';
// import { ITransactionDTO } from '../../Data/ITransaction';

import {connect} from 'react-redux'
import { Action } from 'redux';
import { addTransaction, loadData } from '../../actions/actionTypes';
import {walletGetData} from '../../actions/actionWallet';


function Month(props) {

    const [data,setData] = useState({
        name:"Wilson",
        value:0,
        day:undefined,
        // typeTransaction:null,
        // statusTransaction:null,
        description:'',
    });

    const dataWallet = useLocation().state;

    useEffect(()=>{
        console.log(props)
        console.log(dataWallet)
    },[props])

    const statusTransaction = [
        {name:"Pago", code:StatusTransaction.PAID},
        {name:"Não pago", code:StatusTransaction.NOPAID}
    ]

    const typeTransaction = [
        {name:"Ganho", code:TypeTransaction.GAIN},
        {name:"Gasto", code:TypeTransaction.SPEND}
    ]

    const [chartData] = useState({
        labels: ['Caio', 'Mãe', 'Pai'],
        datasets: [
            {
                data: [300, 50, 100],
                backgroundColor: [
                    "#42A5F5",
                    "#66BB6A",
                    "#BF3030"
                ],
                hoverBackgroundColor: [
                    "#64B5F6",
                    "#81C784",
                    "#FFB74D"
                ]
            }
        ]
    });

    const [lightOptions] = useState({
        plugins: {
            legend: {
                labels: {
                    color: '#495057'
                }
            }
        }
    });


    return(
        <div className='mainContainer'>
            <Link to="/">
                <Button> Voltar</Button>
            </Link>
            <div>
                <div className='dataRow'>
                    {/* <div>
                        <Chart className='pieStyle' type="pie" data={chartData} options={lightOptions} />
                    </div> */}
                    
                    <div className='cardsTransacion'>
                        <Card title="Ganho">
                        <form className='formPosition'>
                    <label htmlFor='name'>Nome</label>
                    <InputText id='name'
                        value={data.name}
                        onChange={(e) => setData({...data,name:e.target.value})}/>

                    <label htmlFor="valor">Valor</label>
                    <InputNumber inputId='valor'
                        value={data.value}
                        onValueChange={e=>setData({...data,value:e.value})}
                        mode="decimal"
                        minFractionDigits={2} />
                    
                    <label htmlFor="data">Data</label>
                    <Calendar id="data"
                        value={data.day}
                        onChange={(e) => setData({...data,day:e.value})}
                        dateFormat="dd/mm/yy"
                        mask="99/99/9999"/>

                    {/* <div>
                    <label htmlFor="typeTransaction">Tipo de Transação</label>
                    <Dropdown value={data.typeTransaction}
                        options={statusTransaction}
                        onChange={e=>setData({...data,typeTransaction:e.target.value})}
                        optionLabel="name"
                        placeholder="Tipo Transacão" />
                    </div>   

                    <div>
                    <label htmlFor="statusTransaction">Status da Transação</label>
                    <Dropdown value={data.statusTransaction}
                        options={typeTransaction}
                        onChange={(e)=>setData({...data,statusTransaction:e.target.value})}
                        optionLabel="name"
                        placeholder="Status" />
                    
                    </div> */}
                    <label htmlFor='description'>Descrição</label>
                    <InputText id='description'
                        value={data.description}
                        onChange={(e) => setData({...data,description:e.target.value})}/>
                    
                </form>
                        <Button className='buttonForm' onClick={()=>{
                            //console.log(data)
                            props.walletGetData(data)
                            }}>Salvar</Button>
                </Card>
                    </div>
                    {<div>
                        <h1>{props.loading?"LOADING":dataWallet.allMoney}</h1>
                    </div>}
                </div>
                </div>
                {/* <Button className='buttonForm' onClick={()=>{
                            console.log(props)
                    
                            }}>Ver status</Button> */}
                <div>
                <DataTableDemo/>
                </div>
            </div>
        
    )
}

// const mapStatetoProps =(state)=>{
//     return{
//         allMoney:state.allMoney,
//         loading:state.loading,
//         listTransactions:state.listTransactions
//     }
// }

const mapDispacthToProps = {

    addTransaction,
    
}

export default connect(null,mapDispacthToProps)(Month);