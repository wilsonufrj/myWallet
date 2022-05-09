import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Badge } from 'primereact/badge';

interface ITransaction{
    name: String,
    value:string|number,
    date:Date,
    creditDebit:string,
    description:string,
    status:string,
    typeTransaction:string
}

const DataTableDemo = () => {

    const [products, setProducts] = useState<Array<ITransaction>>([
        {
            "name": "Jocimar",
            "value":37.90,
            "date": new Date(),
            "creditDebit":"debit",
            "status": "noPaid",
            "description":"Acai na rua",
            "typeTransaction":"Gain"
            
        },{
            "name": "Terezinha",
            "value":100.00,
            "date": new Date(),
            "creditDebit":"debit",
            "status": "paid",
            "description":"Computador",
            "typeTransaction":"Spend"
            
        }
    ])

    const priceBodyTemplate=(data:ITransaction)=>{
        if(data){
            return data.value.toLocaleString('pt-BR',{style:"currency" ,currency:"BRL"});
        }
    }

    const statusBodyTemplate = (data:ITransaction) => {
        if(data.status == "paid"){
            return(<Badge value={data.status} severity="success"></Badge>)
        }
        return(<Badge value={data.status} severity="danger"></Badge>)
    }

    const countryBodyTemplate = (rowData:ITransaction) => {
        return (
            <React.Fragment>
                <img alt="flag" src="./fotoTeste.png" 
                className={`flag flag-${rowData.name}`} 
                width={30}/>
                <span className="image-text">{rowData.name}</span>
            </React.Fragment>
        );
    }
    
    const dateBodyTemplate=(data:ITransaction)=>{
        return formatDate(data.date)
    }

    const formatDate = (value:Date) => {
        return value.toLocaleDateString('en-US', {
            day: '2-digit',
            month: '2-digit',
            year: 'numeric',
        });
    }
    return (
        <div>
            <DataTable value={products}>
            <Column field="name" header="Name" body={countryBodyTemplate}></Column>
            <Column field="value" header="Value" body={priceBodyTemplate}></Column>
            <Column field="date" header="Date" body={dateBodyTemplate}></Column>
            <Column field="creditDebit" header="Credit/Debit"></Column>
            <Column field="status" header="Status" body={statusBodyTemplate}></Column>
        </DataTable>
        </div>
    );
}

export default DataTableDemo;

