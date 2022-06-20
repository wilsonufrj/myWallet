import { InputNumber } from 'primereact/inputnumber';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { InputSwitch } from 'primereact/inputswitch';
import { Card } from 'primereact/card';
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';


import { useState } from 'react';
import { ITransactionDTO } from '../../../Data/ITransaction';


import './style.css'
import { Link } from 'react-router-dom';
import { StatusTransaction } from '../../../enums/typeStatusTransaction';
import { TypeTransaction } from '../../../enums/typeTransaction';

import axios from "axios";
import { config } from 'process';

export const Form=()=>{    
    const [data,setData] = useState<ITransactionDTO>({
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
        axios.post("http://localhost:8080/transaction",data)
        .then((e)=>{
            console.log("Salvo no banco");
            console.log(e.data);
        });
    }

    return(
        <div className='mainCard'>
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

                    <div id='optionTransaction'>

                    
                    <label htmlFor="typeTransaction">Tipo de Transação</label>
                    <Dropdown value={data.typeTransaction}
                        options={statusTransaction}
                        onChange={e=>setData({...data,typeTransaction:e.target.value})}
                        optionLabel="name"
                        placeholder="Tipo Transacão" />

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
                <Button className='buttonForm' onClick={postRequest}>Salvar</Button>
        </div>
    )
}