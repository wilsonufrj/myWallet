
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Calendar } from 'primereact/calendar';
import { InputText } from 'primereact/inputtext';
import { MultiSelect } from 'primereact/multiselect';
import { Dropdown } from 'primereact/dropdown';
import { FilterMatchMode, FilterOperator } from 'primereact/api';

import { connect } from 'react-redux';
import React from 'react';
import { useEffect, useState } from 'react';
import { useParams} from 'react-router-dom';

import { deleteTransaction,editTransaction } from '../../../actions/actionTransaction'
import './style.css'
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { InputNumber } from 'primereact/inputnumber';


const DataListFilter = (props)=>{

    const idURL = useParams()
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [updateTransaction,setUpdateTransaction] = useState({});
    const [position, setPosition] = useState('center');
    const [filters2, setFilters2] = useState({
        'name': { value: null, matchMode: FilterMatchMode.STARTS_WITH },
        'value': { value: null, matchMode: FilterMatchMode.STARTS_WITH },
        'date': {value:null,matchMode:FilterMatchMode.DATE_IS},
        'description': { value: null, matchMode: FilterMatchMode.IN },
        'statusTransaction': { value: null, matchMode: FilterMatchMode.EQUALS },
    });

    useEffect(()=>{},[props.listTransaction])

    const creditOrDebit = [
        'Credito','Debito'
    ]

    const statusTransaction = [
        'Pago','Não Pago'
    ]

    const typeTransaction = [
        'Ganho', 'Gasto'
    ]

    //Por isso aqui no Como template do nome --- Mais pra frente
    // const representativesItemTemplate = (option) => {
    //     return (
    //         <div className="p-multiselect-representative-option">
    //             <img alt={option.name} src={`images/avatar/${option.image}`} onError={(e) => e.target.src = 'https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png'} width={32} style={{ verticalAlign: 'middle' }} />
    //             <span className="image-text">{option.name}</span>
    //         </div>
    //     );
    // }


    //------------------------Value---------------------------------
    const priceBodyTemplate=(data)=>{
        if(data){
            return data.value.toLocaleString('pt-BR',{style:"currency" ,currency:"BRL"});
        }
    }

    //------------------------Date---------------------------------
    const dateBodyTemplate=(data)=>{
        return formatDate(data.day)
    }

    const formatDate = (value) => {
        let auxDate = new Date(value)
        return auxDate.toLocaleDateString('pt-BR', {
            day: '2-digit',
            month: '2-digit',
            year: 'numeric',
        });
    }

    const dateFilterTemplate = (options) => {
        return <Calendar value={options.value} onChange={(e) => options.filterCallback(e.value, options.index)} dateFormat="dd/mm/yy" placeholder="dd/mm/yyyy" mask="99/99/9999" />
    }

    const statusItemTemplate = (option) => {
        return <span className={`customer-badge status-${option}`}>{option}</span>;
    }


    const statusBodyTemplate = (rowData) => {
        return <span className={`customer-badge status-${rowData.status}`}>{rowData.status}</span>;
    }

    const statusRowFilterTemplate = (options) => {
        return <Dropdown value={options.value} options={creditOrDebit} onChange={(e) => options.filterApplyCallback(e.value)} placeholder="Select a Status" className="p-column-filter" showClear />;
    }

    const editAndDeleteTemplate = (transaction)=>{
        return(
            <div >
                <Button onClick={()=>callDialog(transaction)}
                        icon="pi pi-pencil"
                        className='p-button-warning'/>

                <Dialog header="Transaction"
                        visible={displayResponsive}
                        onHide={() => onHide('displayResponsive')}
                        style={{width: '50vw'}}
                        footer={renderFooter('displayResponsive')}>

                <div className="flex justify-content-center">
                    <div className="card">
                        <form className="p-fluid">
                            <div className="field">
                                <label htmlFor='name'>Nome</label>
                                <InputText id='name'
                                    value={updateTransaction.name}
                                    onChange={(e) => setUpdateTransaction({...updateTransaction,name:e.target.value})}/>
                            </div>
                            <div className="field">
                                <label htmlFor="valor">Valor</label>
                                <InputNumber inputId='valor'
                                    value={updateTransaction.value}
                                    onValueChange={e=>setUpdateTransaction({...updateTransaction,value:e.target.value})}
                                    mode="decimal"
                                    minFractionDigits={2} />       
                            </div>
                            <div className="field">
                            <label htmlFor="data">Data</label>
                                <Calendar id="data"
                                    value={new Date(updateTransaction.day)}
                                    onChange={(e) => setUpdateTransaction({...updateTransaction,day:e.target.value})}
                                    dateFormat="dd/mm/yy"
                                    mask="99/99/9999"/>
                            </div>
                            <div className="field">
                                <label htmlFor='description'>Descrição</label>
                                <InputText id='description'
                                    value={updateTransaction.description}
                                    onChange={(e) =>{setUpdateTransaction({...updateTransaction,description:e.target.value})}   
                                        }/>
                                    </div>
                        </form>
                    </div>
                </div>
                    

                </Dialog>
                <Button icon="pi pi-trash" className='p-button-danger' onClick={()=>props.deleteTransaction(transaction.id,idURL.monthId)}></Button>
            </div>
        )
    }

    const renderFooter = (name) => {
        return (
            <div>
                <Button label="Cancelar" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Salvar" icon="pi pi-check" onClick={() =>{
                     onHide(name)
                     props.editTransaction(updateTransaction.id,updateTransaction,idURL.monthId)
                     }} autoFocus />
            </div>
        );
    }
    
    const onHide = (name) => {
        dialogFuncMap[`${name}`](false);
    }

    const callDialog = (transaction)=>{
         setUpdateTransaction({...transaction,id:transaction.id})
        onClick('displayResponsive')
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

    return(
        <div className="datatable-filter-demo">
            <div className="card">
                <DataTable value={props.listTransaction}
                           paginator
                           className="p-datatable-customers"
                           rows={10}
                           dataKey="id"
                           filters={filters2}
                           filterDisplay="row"
                           responsiveLayout="scroll"
                           emptyMessage="No customers found.">

                    <Column field="name"
                            header="Name"
                            filter
                            filterPlaceholder="Search by Name"
                            style={{ minWidth: '12rem' }} />

                    <Column field="value"
                            header="Value"
                            filter
                            filterPlaceholder="Search by Value"
                            style={{ minWidth: '12rem' }}
                            body={priceBodyTemplate} />

                    <Column header="Date"
                            filterField="date"
                            dataType="date"
                            style={{ minWidth: '10rem' }}
                            body={dateBodyTemplate}
                            filter
                            filterElement={dateFilterTemplate} />

                    <Column field="description"
                            header="Descrição"
                            filter
                            filterPlaceholder="Search by descrição"
                            style={{ minWidth: '12rem' }} />

                    <Column
                        header="Editar/Excluir"
                        body={editAndDeleteTemplate}
                    />
                </DataTable>
            </div>
        </div>
    );
}

const mapStateProps = (state)=>{
    return({
        listTransaction:state.monthReducer.listTransaction
    })
}

const mapDispacthToProps = {
    deleteTransaction,
    editTransaction
}

export default connect(mapStateProps,mapDispacthToProps)(DataListFilter);