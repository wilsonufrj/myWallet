import React, { useState } from 'react';
import { Button } from 'primereact/button';
import { Link} from 'react-router-dom';
import "./style.css";
import { Card } from 'primereact/card';
import { Chart } from 'primereact/chart';

import DataTableDemo from '../components/DataList/App';

import { InputNumber } from 'primereact/inputnumber';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { InputSwitch } from 'primereact/inputswitch';

import { Dropdown } from 'primereact/dropdown';


import axios from "axios";
import { StatusTransaction } from '../../enums/typeStatusTransaction';
import { TypeTransaction } from '../../enums/typeTransaction';
// import { ITransactionDTO } from '../../Data/ITransaction';

import {connect} from 'react-redux'
import { Action } from 'redux';
import { addTransaction } from '../../actions/actionTypes';


function Month({value,addTransaction}) {

    const [data,setData] = useState({
        name:"Wilson",
        value:0,
        day:undefined,
        typeTransaction:null,
        statusTransaction:null,
        description:'',
        isMonthly:false 
    });


    const statusTransaction = [
        {name:"Pago", code:StatusTransaction.PAID},
        {name:"Não pago", code:StatusTransaction.NOPAID}
    ]

    const typeTransaction = [
        {name:"Ganho", code:TypeTransaction.GAIN},
        {name:"Gasto", code:TypeTransaction.SPEND}
    ]
    
    const postRequest = ()=>{
        console.log(data)
        axios.post("http://localhost:8080/transaction",data)
        .then((e)=>{
            console.log("Salvo no banco");
            console.log(e.data);
        });
    }

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
                        onValueChange={e=>{
                            if(!e.target.value)
                               setData({...data,value:e.value})
                            else
                                setData(data)
                        }}
                        mode="decimal"
                        minFractionDigits={2} />
                    
                    <label htmlFor="data">Data</label>
                    <Calendar id="data"
                        value={data.day}
                        onChange={(e) => setData({...data,day:e.value})}
                        dateFormat="dd/mm/yy"
                        mask="99/99/9999"/>

                    <div>
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
                    
                    </div>
                    <label htmlFor='description'>Descrição</label>
                    <InputText id='description'
                        value={data.description}
                        onChange={(e) => setData({...data,description:e.target.value})}/>
                    
                </form>
                <Button className='buttonForm' onClick={addTransaction}>Salvar</Button>
                        </Card>
                    </div>
                    <div>
                        <h1>{value}</h1>
                    </div>
                </div>
                </div>
               
                <div>
                <DataTableDemo/>
                </div>
            </div>
        
    )
}

const mapStatetoProps =(state)=>{
    return{
        value:state.value
    }
}

const mapDispacthToProps = (dispatch)=>{
    return {
        addTransaction:()=>dispatch(addTransaction)
    }
}

export default connect(
                    mapStatetoProps,
                    mapDispacthToProps)(Month);