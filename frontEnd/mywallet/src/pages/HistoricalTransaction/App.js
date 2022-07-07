import { Card } from "primereact/card";
import { Button } from "primereact/button";
import { Dialog } from 'primereact/dialog';
import { InputNumber } from 'primereact/inputnumber';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { InputSwitch } from 'primereact/inputswitch';

import { Dropdown } from 'primereact/dropdown';


import DataTableDemo from "../components/DataList/App";
import Sidebar from "../components/Sidebar/App";
import { addTransaction } from "../../actions/actionTransaction";
import { StatusTransaction } from "../../enums/typeStatusTransaction";
import { TypeTransaction } from "../../enums/typeTransaction";

import {useState } from "react";
import {connect} from 'react-redux'
import { useParams} from 'react-router-dom';
import { CreditOrDebit } from "../../enums/creditOrDebit";

const HistoricalTransaction = (props)=>{

    const idURL = useParams()
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [position, setPosition] = useState('center');
    const [data,setData] = useState({
        name:"Wilson",
        value:0,
        day:undefined,
        typeTransaction:null,
        statusTransaction:null,
        creditOrDebit:null,
        description:'',
    });

    const renderFooter = (name) => {
        return (
            <div>
                <Button label="Cancelar" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Salvar" icon="pi pi-check" onClick={() =>{
                     onHide(name)
                     props.addTransaction(data)
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

    const dialogFuncMap = {
        'displayResponsive': setDisplayResponsive
    }

    const statusTransaction = {
        paid:StatusTransaction.PAID,
        noPaid:StatusTransaction.NOPAID
    }

    const typeTransaction = {
        gain:TypeTransaction.GAIN,
        spend:TypeTransaction.SPEND
    }

    const creditOrDebit = {
        credit:CreditOrDebit.CREDIT,
        debit:CreditOrDebit.DEBIT
    }

    return(
        <div>
            <Sidebar/>
            <div className="mainContainer">
                <h1>Historico de Transações</h1>
                <Button onClick={()=> onClick('displayResponsive')}>Nova Carteira</Button>
                <Dialog header="Nova Transaction" visible={displayResponsive} onHide={() => onHide('displayResponsive')} breakpoints={{'960px': '75vw'}} style={{width: '50vw'}} footer={renderFooter('displayResponsive')}>
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
                        <div>
                        <label htmlFor="creditOrdebit">Crédito ou Débito</label>
                        <Dropdown value={data.creditOrDebit}
                            options={creditOrDebit}
                            onChange={(e)=>setData({...data,creditOrDebit:e.target.value})}
                            optionLabel="name"
                            placeholder="Crédito ou Débito" />
                        
                        </div>


                        <label htmlFor='description'>Descrição</label>
                        <InputText id='description'
                            value={data.description}
                            onChange={(e) => setData({...data,description:e.target.value})}/>
                        
                    </form>
                </Dialog>
                <div className="rowData">
                    <div>
                        <DataTableDemo/>
                    </div>
                    <div>
                        <Card title="Total">
                            <div>
                                <span>RS300,00</span>
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
        listTransaction:state.transactionReducer.listTransaction,
    }
}

const mapDispacthToProps = {
    addTransaction
}

export default connect(mapStateProps,mapDispacthToProps)(HistoricalTransaction);