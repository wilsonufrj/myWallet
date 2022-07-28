import { Card } from "primereact/card";
import { Button } from "primereact/button";
import { Dialog } from 'primereact/dialog';
import { InputNumber } from 'primereact/inputnumber';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { InputSwitch } from 'primereact/inputswitch';

import { Dropdown } from 'primereact/dropdown';


import Sidebar from "../components/Sidebar/App";
import { addTransaction } from "../../actions/actionTransaction";
import { StatusTransaction } from "../../enums/typeStatusTransaction";
import { TypesTransaction } from "../../enums/typeTransaction";

import {useEffect, useState } from "react";
import {connect} from 'react-redux'
import { useParams} from 'react-router-dom';
import { CreditOrDebit } from "../../enums/creditOrDebit";

import './style.css'
import DataListFilter from "../components/DataListFilter";
import { getWalletData } from "../../actions/actionMonth";

const HistoricalTransaction = (props)=>{

    const idURL = useParams()
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [search,setSearch] = useState(" ")
    const [position, setPosition] = useState('center');
    const [data,setData] = useState({
        name:"Wilson"});
    const [enumName,setEnumName]=useState({})
    

    // const getFormErrorMessage = (name) => {
    //     return errors[name] && <small className="p-error">{errors[name].message}</small>
    // };

    useEffect(()=>{
        props.getWalletData(idURL.monthId);
    },[idURL,props])

    const renderFooter = (name) => {
        return (
            <div>
                <Button label="Cancelar" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Salvar" icon="pi pi-check" onClick={() =>{
                     onHide(name)
                     props.addTransaction(idURL.monthId,data)
                     }} autoFocus />
            </div>
        );
    }
    const onHide = (name) => {
        dialogFuncMap[`${name}`](false);
    }

    const onClick = (name, position) => {
        dialogFuncMap[`${name}`](true);

        if (position) {
            setPosition(position);
        }
    }

    // const AtualizaDropdown =(e,nameData) =>{
    //     setData({
    //         ...data,
    //         auxName:e.target.value.code
    //     })
    //     setEnumName({
    //         ...enumName,
    //         :e.target.value

    //     })
        
    // }

    const dialogFuncMap = {
        'displayResponsive': setDisplayResponsive
    }

    const statusTransaction = [
        {name:"Pago",code:StatusTransaction.PAID},
        {name:"Nao Pago", code:StatusTransaction.NOPAID}
    ]

    const typeTransaction = [
        {name:"Ganho",code:TypesTransaction.GAIN},
        {name:"Gasto",code:TypesTransaction.SPEND}
    ]

    const creditOrDebit = [
       {name:"Crédito", code:CreditOrDebit.CREDIT},
        { name: "Débito", code:CreditOrDebit.DEBIT}
    ]

    return(
        <div>
            <Sidebar/>
            <div className="mainContainer">
                <Button onClick={()=> onClick('displayResponsive')}>Nova Transação</Button>
                <Dialog header="Nova Transaction" visible={displayResponsive} onHide={() => onHide('displayResponsive')} breakpoints={{'960px': '75vw'}} style={{width: '50vw'}} footer={renderFooter('displayResponsive')}>
                <div className="flex justify-content-center">
                    <div className="card">
                        <form className="p-fluid">
                            <div className="field">
                                <label htmlFor='name'>Nome</label>
                                <InputText id='name'
                                    value={data.name}
                                    onChange={(e) => setData({...data,name:e.target.value})}/>
                            </div>
                            <div className="field">
                                <label htmlFor="valor">Valor</label>
                                <InputNumber inputId='valor'
                                    value={data.value}
                                    onValueChange={e=>setData({...data,value:e.value})}
                                    mode="decimal"
                                    minFractionDigits={2} />       
                            </div>
                            <div className="field">
                            <label htmlFor="data">Data</label>
                                <Calendar id="data"
                                    value={data.day}
                                    onChange={(e) => setData({...data,day:e.value})}
                                    dateFormat="dd/mm/yy"
                                    mask="99/99/9999"/>
                            </div>
                            <div className="field">
                                <label htmlFor='description'>Descrição</label>
                                <InputText id='description'
                                    value={data.description}
                                    onChange={(e) =>{ setData({...data,description:e.target.value})}}/>
                                    </div>
                            <div className="field">
                                <label htmlFor="creditOrdebit">Crédito ou Débito</label>
                                <Dropdown value={enumName.creditOrDebit}
                                    options={creditOrDebit}
                                    onChange={(e)=>{
                                        setData({
                                            ...data,
                                            creditOrDebit:e.target.value.code
                                        })
                                        setEnumName({
                                            ...enumName,
                                            creditOrDebit:e.target.value
                                
                                        })
                                    }}
                                    optionLabel="name"
                                    placeholder="Crédito ou Débito" />
                            </div>
                            <div className="field">
                                <label htmlFor="typeTransaction">Tipo de Transação</label>
                                <Dropdown value={enumName.typeTransaction}
                                    options={typeTransaction}
                                    onChange={e=>{
                                        setData({
                                            ...data,
                                            typeTransaction:e.target.value.code
                                        })
                                        setEnumName({
                                            ...enumName,
                                            typeTransaction:e.target.value
                                
                                        })
                                    }}
                                    optionLabel="name"
                                    placeholder="Tipo Transacão" />
                            </div>
                            <div className="field">
                                <label htmlFor="statusTransaction">Status da Transação</label>
                                <Dropdown value={enumName.statusTransaction}
                                    options={statusTransaction}
                                    onChange={(e)=>{
                                        setData({
                                            ...data,
                                            statusTransaction:e.target.value.code
                                        })
                                        setEnumName({
                                            ...enumName,
                                            statusTransaction:e.target.value
                                
                                        })
                                    }}
                                    optionLabel="name"
                                    placeholder="Status" />
                            </div>
                        </form>
                    </div>
                    </div>
                 </Dialog>
                <div className="rowData">
                    <div>
                        <DataListFilter/>
                    </div>
                    <div>
                        <Card title="Total">
                            <div>
                                <h1>R${props.allMoney}</h1>
                            </div>
                        </Card>
                    </div>
                </div>
            </div>
        </div>
    );
}

const mapStateProps = (state)=>{
    return{
        allMoney:state.monthReducer.allMoney,
    }
}

const mapDispacthToProps = {
    addTransaction,
    getWalletData
}

export default connect(mapStateProps,mapDispacthToProps)(HistoricalTransaction);