import React, { useEffect, useState } from "react";
import { Dialog } from "primereact/dialog";
import { InputTextarea } from "primereact/inputtextarea";
import { InputNumber } from "primereact/inputnumber";
import { Button } from "primereact/button";
import { Dropdown } from "primereact/dropdown";
import { Calendar } from "primereact/calendar";

import { useAppDispatch } from "../redux/hooks";
import { adicionarEditarGanhos } from "../pages/Home/homeSlice";
import { ITransacao } from "../pages/Home/Mes/Rateio";

declare interface PropsTransacaoGanhosDialog {
    transacao: ITransacao
    dialogState: boolean
    setDialogState: Function
}
const TransacaoGanhosDialog = (props: PropsTransacaoGanhosDialog) => {

    const dispatch = useAppDispatch();


    const [transacaoData, setTransacaoData] = useState<ITransacao>({} as ITransacao);

    const bancos = [
        { name: 'Nubank', code: 'Nubank' },
        { name: 'Itau', code: 'Itau' },
        { name: 'Picpay', code: 'Picpay' },
        { name: 'Banco do Brasil', code: 'BancoDoBrasil' }
    ];

    useEffect(() => {
        setTransacaoData({ ...props.transacao })
    }, [])

    const hideDialog = () => {
        props.setDialogState(false);
    };

    const transactionDialogFooter = (
        <React.Fragment>
            <Button label="Cancel" icon="pi pi-times" outlined onClick={hideDialog} />
            <Button label="Save" icon="pi pi-check" onClick={() => {
                dispatch(adicionarEditarGanhos(transacaoData))
                props.setDialogState(false);
            }} />
        </React.Fragment>
    );

    const handlerSelecionarBanco = () => {
        if (transacaoData) {
            let bancoSelecionado = bancos.find(item => item.code === transacaoData.banco)
            return bancoSelecionado;
        }
    }

    return (

        <Dialog visible={props.dialogState}
            style={{ width: '32rem' }}
            breakpoints={{ '960px': '75vw', '641px': '90vw' }}
            header="Detalhes da Transação"
            modal
            className="p-fluid"
            footer={transactionDialogFooter}
            onHide={hideDialog}>

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
                    value={handlerSelecionarBanco()}
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
                        onValueChange={(e) => console.log("Deve fazer algo")}
                        mode="currency"
                        currency="BRL"
                        locale="pt-BR" />
                </div>
            </div>
        </Dialog>
    );
}

export default TransacaoGanhosDialog;