import React, { useEffect, useState } from "react";
import { ITransacaoGastos } from "../database/mockDados";
import { Dialog } from "primereact/dialog";
import { InputTextarea } from "primereact/inputtextarea";
import { InputNumber } from "primereact/inputnumber";
import { Button } from "primereact/button";
import { Dropdown } from "primereact/dropdown";
import { Calendar } from "primereact/calendar";
import { useAppDispatch } from "../redux/hooks";
import { adicionarEditarGastos } from "../pages/Home/homeSlice";

declare interface IPropsTransacaoGanhosDialog {
    transacao: ITransacaoGastos
    dialogState: boolean
    setDialogState: Function
}

declare interface IDropdown {
    code: string,
    name: string
}

const TransacaoGastosDialog = (props: IPropsTransacaoGanhosDialog) => {
    const dispatch = useAppDispatch();

    const [transacaoData, setTransacaoData] = useState<ITransacaoGastos>({} as ITransacaoGastos);



    const bancos: IDropdown[] = [
        { name: 'Nubank', code: 'Nubank' },
        { name: 'Itau', code: 'Itau' },
        { name: 'Picpay', code: 'Picpay' }
    ];

    const devedores: IDropdown[] = [
        { name: 'Wilson', code: 'Wilson' },
        { name: 'Gabrielle', code: 'Gabrielle' },
        { name: 'Terezinha', code: 'Terezinha' },
        { name: 'Jocimar', code: 'Jocimar' },
        { name: 'Caio', code: 'Caio' },
    ];

    const tipoGasto: IDropdown[] = [
        { name: 'Debito', code: 'Debito' },
        { name: 'Credito', code: 'Credito' }
    ];

    useEffect(() => {
        setTransacaoData({ ...props.transacao })
    }, [])

    const hideDialog = () => {
        props.setDialogState(false);
    };

    const transactionDialogFooter = (
        <React.Fragment>
            <Button label="Cancelar" icon="pi pi-times" outlined onClick={hideDialog} />
            <Button label="Salvar" icon="pi pi-check" onClick={() => {
                dispatch(adicionarEditarGastos(transacaoData))
                props.setDialogState(false);
            }} />
        </React.Fragment>
    );

    const handlerDropdown = (
        transacao: any,
        lista: IDropdown[],
        alvo: keyof typeof transacao
    ): IDropdown | undefined => {
        if (transacao && alvo in transacao) {
            return lista.find((item: IDropdown) => item.code === transacao[alvo]);
        }
        return undefined;
    };

    return (

        <Dialog visible={props.dialogState}
            style={{ width: '32rem' }}
            breakpoints={{ '960px': '75vw', '641px': '90vw' }}
            header="Detalhes da Transação"
            modal
            className="p-fluid"
            footer={transactionDialogFooter}
            onHide={hideDialog}>
            <div className="flex">
                <div className="field">
                    <label htmlFor="devedor" className="font-bold">
                        Devedor
                    </label>
                    <Dropdown
                        id="devedor"
                        value={handlerDropdown(transacaoData, devedores, "devedor")}
                        onChange={(e) => setTransacaoData({ ...transacaoData, devedor: e.target.value.code })}
                        options={devedores}
                        optionLabel="name"
                        placeholder="Selecione o Devedor"
                        className="w-full md:w-14rem" />
                </div>
                <div className="field ml-2">
                    <label htmlFor="tipoGasto" className="font-bold">
                        Tipo
                    </label>
                    <Dropdown
                        id="tipoGasto"
                        value={handlerDropdown(transacaoData, tipoGasto, "tipoGasto")}
                        onChange={(e) => setTransacaoData({ ...transacaoData, tipoGasto: e.target.value.code })}
                        options={tipoGasto}
                        optionLabel="name"
                        placeholder="Selecione o Tipo"
                        className="w-full md:w-14rem" />
                </div>
            </div>

            <div className="field">
                <label htmlFor="data" className="font-bold">
                    Data
                </label>
                <Calendar value={new Date(transacaoData.data)}
                    dateFormat="dd/mm/yy"
                    onChange={(e) => {
                        if (e.target.value) {
                            setTransacaoData({ ...transacaoData, data: e.target.value.toISOString() })
                        }
                    }} />
            </div>

            <div className="field">
                <label htmlFor="description" className="font-bold">
                    Description
                </label>
                <InputTextarea id="description"
                    value={transacaoData?.descricao}
                    onChange={(e) => setTransacaoData({ ...transacaoData, descricao: e.target.value })}
                    required
                    rows={3}
                    cols={20} />
            </div>
            <div className="field">
                <label htmlFor="bancos" className="font-bold">
                    Bancos
                </label>
                <Dropdown
                    id="bancos"
                    value={handlerDropdown(transacaoData, bancos, "banco")}
                    onChange={(e) => setTransacaoData({ ...transacaoData, banco: e.target.value.code })}
                    options={bancos}
                    optionLabel="name"
                    placeholder="Selecione o Banco"
                    className="w-full md:w-14rem" />
            </div>
            <div className="formgrid grid">
                <div className="field col-6">
                    <label htmlFor="valor" className="font-bold">
                        Valor
                    </label>
                    <InputNumber id="valor"
                        value={transacaoData?.valor}
                        onValueChange={(e) => setTransacaoData({ ...transacaoData, valor: e.target.value })}
                        mode="currency"
                        currency="BRL"
                        locale="pt-BR" />
                </div>
            </div>
        </Dialog>
    );
}

export default TransacaoGastosDialog;