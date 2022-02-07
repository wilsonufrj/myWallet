import { InputNumber } from 'primereact/inputnumber';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { InputSwitch } from 'primereact/inputswitch';


import { useState } from 'react';
import { IGanho } from '../../../Data/IGanho';


import './style.css'
import { Button } from 'primereact/button';
export const Form=()=>{
    const [data,setData] = useState<IGanho>({
        value:0,
        day:undefined,
        description:'',
        isMonthly:false 
    });


    return(
        <div className='form'>

            <label htmlFor="valor">Valor</label>
            <InputNumber inputId='valor'
                value={data.value}
                onValueChange={e=>setData({...data,value:e.value})}
                mode="decimal"
                minFractionDigits={2} />
            
            <label htmlFor="mask">Data</label>
            <Calendar id="mask"
                value={data.day}
                onChange={(e) => setData({...data,day:e.value})}
                dateFormat="dd/mm/yy"
                mask="99/99/9999"/>

            <label htmlFor='description'>Descrição</label>
            <InputText id='description'
                value={data.description}
                onChange={(e) => setData({...data,description:e.target.value})}/>
            
            <label htmlFor='isMonthly'>Tem todo mes?</label>
            <InputSwitch id='isMonthly'
                checked={data.isMonthly} 
                onChange={(e) => setData({...data,isMonthly:e.value})}/>

            <Button className='p-button-success'>Adicionar</Button>
        </div>
    )
}