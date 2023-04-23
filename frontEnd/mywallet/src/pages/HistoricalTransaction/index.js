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

import { useEffect, useState } from "react";
import { connect } from 'react-redux'
import { useParams } from 'react-router-dom';
import { CreditOrDebit } from "../../enums/creditOrDebit";

import './style.css'
import DataListFilter from "../components/DataListFilter";
import { getWalletData } from "../../actions/actionMonth";
import { Controller, useForm } from "react-hook-form";

const HistoricalTransaction = (props) => {

    const idURL = useParams()
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [search, setSearch] = useState(" ");
    const [position, setPosition] = useState('center');
    const { register, handleSubmit, control } = useForm();

    useEffect(() => {
        props.getWalletData(idURL.monthId);
    }, [idURL, props])

    const renderFooter = (name) => {
        return (
            <div>
                <Button label="Cancelar" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Salvar" icon="pi pi-check" onClick={() => {
                    onHide(name)
                    handleSubmit(onSubmit)()
                }} autoFocus />
            </div>
        );
    }

    const onSubmit = (data) => {
        props.addTransaction(idURL.monthId,
             {...data,
                creditOrDebit:data.creditOrDebit.code,
                typeTransaction: data.typeTransaction.code,
                statusTransaction:data.statusTransaction.code
            })
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

    const statusTransaction = [
        { name: "Pago", code: StatusTransaction.PAID },
        { name: "Nao Pago", code: StatusTransaction.NOPAID }
    ]

    const typeTransaction = [
        { name: "Ganho", code: TypesTransaction.GAIN },
        { name: "Gasto", code: TypesTransaction.SPEND }
    ]

    const creditOrDebit = [
        { name: "Crédito", code: CreditOrDebit.CREDIT },
        { name: "Débito", code: CreditOrDebit.DEBIT }
    ]

    return (
        <div>
            <Sidebar />
            <div className="mainContainer">
                <Button onClick={() => onClick('displayResponsive')}>Nova Transação</Button>
                <Dialog header="Nova Transaction" visible={displayResponsive} onHide={() => onHide('displayResponsive')} breakpoints={{ '960px': '75vw' }} style={{ width: '50vw' }} footer={renderFooter('displayResponsive')}>
                    <div className="flex justify-content-center">
                        <div className="card">
                            <form className="p-fluid">
                                <div className="field">
                                    <label htmlFor='name'>Nome</label>
                                    <InputText id='name'
                                        {...register('name')}
                                    />
                                </div>
                                <div className="field">
                                    <label htmlFor="value">Valor</label>
                                    <Controller
                                        name="value"
                                        control={control}
                                        render={({ field }) =>
                                        <InputNumber inputId="currency-us"
                                        value={field.value}
                                        onValueChange={(e) => field.onChange(e.value)}
                                        mode="currency"
                                        currency="USD"
                                        locale="en-US"/>
                                        }
                                        
                                    />
                                    
                                </div>
                                <div className="field">
                                    <label htmlFor="data">Data</label>
                                    <Calendar id="date"
                                        {...register('date')}
                                        dateFormat="dd/mm/yy"
                                        mask="99/99/9999" />
                                </div>
                                <div className="field">
                                    <label htmlFor='description'>Descrição</label>
                                    <InputText id='description'
                                        {...register('description')}
                                    />
                                </div>
                                <div className="field">
                                    <label htmlFor="creditOrDebit">Crédito ou Débito</label>
                                    <Controller
                                        name="creditOrDebit"
                                        control={control}
                                        render={({ field }) =>
                                            <Dropdown
                                                value={field.value}
                                                options={creditOrDebit}
                                                control={control}
                                                onChange={(e) => field.onChange(e.value)}
                                                optionLabel="name"
                                                placeholder="Crédito ou Débito" />
                                        }
                                    />

                                </div>
                                <div className="field">
                                    <label htmlFor="typeTransaction">Tipo de Transação</label>
                                    <Controller
                                        name="typeTransaction"
                                        control={control}
                                        render={({ field }) =>
                                       
                                            <Dropdown
                                                value={field.value}
                                                options={typeTransaction}
                                                control={control}
                                                onChange={(e) => field.onChange(e.value)}
                                                optionLabel="name"
                                                placeholder="Tipo Transacão" />
                                        }
                                    />
                                </div>
                                <div className="field">
                                    <label htmlFor="statusTransaction">Status da Transação</label>
                                    <Controller
                                        name="statusTransaction"
                                        control={control}
                                        render={({ field }) =>
                                            <Dropdown
                                                value={field.value}
                                                options={statusTransaction}
                                                control={control}
                                                onChange={(e) => field.onChange(e.value)}
                                                optionLabel="name"
                                                placeholder="Status" />
                                        }
                                    />
                                </div>
                            </form>
                        </div>
                    </div>
                </Dialog>
                <div className="row">
                    <div>
                        <DataListFilter />
                    </div>
                    <div id='cardValor' >
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

const mapStateProps = (state) => {
    return {
        allMoney: state.monthReducer.allMoney,
    }
}

const mapDispacthToProps = {
    addTransaction,
    getWalletData
}

export default connect(mapStateProps, mapDispacthToProps)(HistoricalTransaction);