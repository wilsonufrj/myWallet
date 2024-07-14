import React from "react";

import { Card } from 'primereact/card';
import { Button } from 'primereact/button';
import { useAppDispatch, useAppSelector } from "../../redux/hooks";
import {getWallet} from '../../pages/Home/walletSlice';

interface PropsWallet{
    id:number|null,
    name:string,
    description:string
}

export default function Wallet(props:PropsWallet) {

    const dispatch = useAppDispatch();

    const handleAcessButton = ()=>{
        dispatch(getWallet(props.id))
    }

    const footer = (
        <>
            <Button label="Open Wallet" icon="pi pi-check" />
            <Button label="Remove Wallet" onClick={handleAcessButton} icon="pi pi-times" style={{ marginLeft: '0.5em' }} />
        </>
    );

    return (
        <Card title={props.name} subTitle="Card subtitle" footer={footer} className="md:w-25rem">
            <p>{props.description}</p>
        </Card>

    );
}
