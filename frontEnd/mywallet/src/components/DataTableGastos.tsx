import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Toolbar } from "primereact/toolbar";
import React, { useEffect, useState } from "react";
import { ITransacao, ITransacaoGastos } from "../database/mockDados";
import { ColumnGroup } from "primereact/columngroup";
import { Row } from "primereact/row";
import { Button } from "primereact/button";
import TransacaoGastosDialog from "./TransacaoGastosDialog";
import { useAppDispatch } from "../redux/hooks";
import { removerGastos } from "../pages/Home/homeSlice";
import { FilterMatchMode } from 'primereact/api';
import { InputText } from "primereact/inputtext";


declare interface PropsDataTableGanhos {
    transacoes: ITransacaoGastos[]
    titulo: string
}

const DataTableGastos = (props: PropsDataTableGanhos) => {

    const dispatch = useAppDispatch();

    const [transacaoDialog, setTransacaoDialog] = useState<boolean>(false);
    const [visibleTransacoes, setVisibleTransacoes] = useState<ITransacaoGastos[]>(props.transacoes);

    const [selectedTransacao, setSelectedTransacao] = useState<ITransacaoGastos>({} as ITransacaoGastos);
    const [selectedTransacoes, setSelectedTransacoes] = useState<ITransacaoGastos[]>([]);

    const [filters, setFilters] = useState({
        'responsavel': { value: null, matchMode: FilterMatchMode.CONTAINS },
    });

    useEffect(()=>{
        setVisibleTransacoes(props.transacoes)
    },[props.transacoes])
    
    const somaValor = (lista: ITransacaoGastos[]) => {
        return lista.reduce((total, transacao) => total + (transacao.valor ?? 0), 0);
    }

    const formatCurrency = (value: number) => {
        return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    };

    const footerGroupGanhos = (
        <ColumnGroup>
            <Row>
                <Column footer="Total" colSpan={6} footerStyle={{ textAlign: 'left' }} />
                <Column footer={formatCurrency(somaValor(visibleTransacoes))} colSpan={1} footerStyle={{ textAlign: 'left' }} />
            </Row>
        </ColumnGroup>
    );

    const dataTemplate = (item: ITransacao) => {
        return new Date(item.data).toLocaleDateString("pt-BR", {
            day: "2-digit",
            month: "2-digit",
            year: "numeric"
        });
    }

    const priceBodyTemplate = (item: any) => {
        return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(item.valor);
    };

    const leftToolbarTemplate = () => {
        return (
            <div className="flex flex-wrap gap-2">
                <Button label="Novo"
                    icon="pi pi-plus"
                    severity="success"
                    onClick={() => {
                        setTransacaoDialog(true);
                        setSelectedTransacao({} as ITransacaoGastos)
                    }} />
                <Button label="Delete"
                    icon="pi pi-trash"
                    severity="danger"
                    onClick={deletarTransacoes}
                    disabled={!selectedTransacoes?.length} />

            </div>
        );
    };

    const deletarTransacoes = () => {
        let transacoesSelecionadas = selectedTransacoes.map(transacao => transacao.id)
        dispatch(removerGastos(transacoesSelecionadas))
        setSelectedTransacoes([])
    }

    const ResponsavelRowFilterTemplate = (options: any) => {
        return (
            <InputText
                value={options.value || ''} 
                onChange={(e) => {
                    const filterValue = e.target.value;
                    options.filterApplyCallback(filterValue);
                }}
                placeholder="Procurar por Responsável"
            />
        );
    };

    return (
        <div id="tabela">
            <div>
                <h1>{props.titulo}</h1>
            </div>
            <div className=''>
                <div className="">
                    <Toolbar className="mb-4" start={leftToolbarTemplate}></Toolbar>

                    <DataTable value={props.transacoes}
                        footerColumnGroup={footerGroupGanhos}
                        selection={selectedTransacoes}
                        onSelectionChange={(e) => setSelectedTransacoes(e.value)}
                        selectionMode="checkbox"
                        onRowDoubleClick={(e) => {
                            setTransacaoDialog(true);
                            setSelectedTransacao(e.data as ITransacaoGastos)
                        }}
                        filters={filters}
                        onValueChange={(filteredData) => setVisibleTransacoes(filteredData)}
                        filterDisplay="row"
                        emptyMessage="Nenhum resultado.">

                        <Column selectionMode="multiple"
                            exportable={false} />

                        <Column field="responsavel"
                            filter
                            filterPlaceholder="Procurar por Responsavel"
                            header="Responsável"
                            style={{ maxWidth: '15rem' }}
                            filterElement={ResponsavelRowFilterTemplate}
                            />

                        <Column field="tipoGasto"
                            header="Tipo Gasto" />

                        <Column field="data"
                            header="Data"
                            sortable
                            body={dataTemplate}
                            style={{ maxWidth: '10rem' }} />

                        <Column field="descricao"
                            header="Descrição" />

                        <Column field="banco"
                            header="Banco" />

                        <Column field="valor"
                            header="Valor"
                            body={priceBodyTemplate} />
                    </DataTable>
                </div>
            </div>
            {
                transacaoDialog
                    ? <TransacaoGastosDialog dialogState={transacaoDialog}
                        setDialogState={setTransacaoDialog}
                        transacao={selectedTransacao}
                    />
                    : <></>
            }


        </div>)
}

export default DataTableGastos;