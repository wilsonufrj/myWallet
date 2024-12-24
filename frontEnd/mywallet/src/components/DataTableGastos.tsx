import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Toolbar } from "primereact/toolbar";
import React, { useState } from "react";
import { ITransacao, ITransacaoGastos } from "../database/mockDados";
import { ColumnGroup } from "primereact/columngroup";
import { Row } from "primereact/row";
import { Button } from "primereact/button";
import TransacaoGastosDialog from "./TransacaoGastosDialog";
import { useAppDispatch } from "../redux/hooks";
import { removerGastos } from "../pages/Home/homeSlice";

declare interface PropsDataTableGanhos {
    transacoes: ITransacao[]
    titulo: string
}

const DataTableGastos = (props: PropsDataTableGanhos) => {

    const dispatch = useAppDispatch();

    const [transacaoDialog, setTransacaoDialog] = useState<boolean>(false);

    const [selectedTransacao, setSelectedTransacao] = useState<ITransacaoGastos>({} as ITransacaoGastos);
    const [selectedTransacoes, setSelectedTransacoes] = useState<ITransacaoGastos[]>([]);

    const somaValor = (lista: ITransacao[]) => {
        let valorTotal: number = 0;
        lista.forEach(transacao => {
            if (transacao?.valor)
                valorTotal += transacao.valor
        });
        return valorTotal;
    }

    const formatCurrency = (value: number) => {
        return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    };

    const footerGroupGanhos = (
        <ColumnGroup>
            <Row>
                <Column footer="Total" colSpan={6} footerStyle={{ textAlign: 'left' }} />
                <Column footer={formatCurrency(somaValor(props.transacoes))} colSpan={1} footerStyle={{ textAlign: 'left' }} />
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
        let transacoesSelecionadas = selectedTransacoes.map(transacao=> transacao.id)
        dispatch(removerGastos(transacoesSelecionadas))
        setSelectedTransacoes([])
    }

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
                        onSelectionChange={(e) => setSelectedTransacoes(e.value as ITransacaoGastos[])}
                        selectionMode="checkbox"
                        onRowDoubleClick={(e) => {
                            setTransacaoDialog(true);
                            setSelectedTransacao(e.data as ITransacaoGastos)
                        }}
                        className="">
                        <Column selectionMode="multiple" exportable={false}></Column>
                        <Column field="devedor" header="Devedor"></Column>
                        <Column field="tipoGasto" header="Tipo Gasto"></Column>
                        <Column field="data" header="Data" body={dataTemplate}></Column>
                        <Column field="descricao" header="Descrição" ></Column>
                        <Column field="banco" header="Banco" ></Column>
                        <Column field="valor" header="Valor" body={priceBodyTemplate}></Column>
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