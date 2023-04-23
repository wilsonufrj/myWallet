import Footer from "../components/footer/App";
import "./style.css";

import { Card } from 'primereact/card';
import { Link } from "react-router-dom";
import { Button } from "primereact/button";
import { Dialog } from 'primereact/dialog';

import { connect } from 'react-redux'
import { createWallet, getAllWallets, deleteWallet } from "../../actions/actionWallet";
import { useEffect, useState } from "react";
import { InputText } from "primereact/inputtext";
import { useForm } from "react-hook-form";



function Home(props) {
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [position, setPosition] = useState('center');
    const { register, handleSubmit } = useForm();

    useEffect(() => {
        props.getAllWallets()
    }, [])

    const renderFooter = (name) => {
        return (
            <div>
                <Button label="Cancelar" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Salvar" icon="pi pi-check" onClick={() => {
                    handleSubmit(onSubmit)()
                    onHide(name)
                }} autoFocus />
            </div>
        );
    }

    const onSubmit = (data) => {
        props.createWallet(data)
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

    return (
        <div>
            <h1 className="title">Bem vindo ao myWallet</h1>
            <div className="mainContainerHome">
                <Button onClick={() => onClick('displayResponsive')}>Nova Carteira</Button>
                <Dialog header="Nova Carteira" visible={displayResponsive} onHide={() => onHide('displayResponsive')} breakpoints={{ '960px': '75vw' }} style={{ width: '50vw' }} footer={renderFooter('displayResponsive')}>
                    <form>
                        <InputText placeholder="Name" htmlFor="nameWallet" {...register('name')} />
                        <InputText placeholder="Description" htmlFor="descriptionWallet" {...register('description')} />
                    </form>
                </Dialog>
                <div className="months">
                    {
                        props.loading ? "LOADING" :
                            props.listWallet.map((data, index) => {
                                return (
                                    <Card key={index} title={data.name} subTitle={data.description}>
                                        <Link to={`/month/${data.id}`}>
                                            <Button>Acessar</Button>
                                        </Link>
                                        <Button
                                            icon="pi pi-trash"
                                            iconPos="right"
                                            label="Deletar"
                                            className="p-button-danger"
                                            onClick={() => props.deleteWallet(data.id)}>
                                        </Button>
                                    </Card>
                                )
                            })
                    }
                </div>
            </div>
        </div>
    )
}

const mapStateProps = (state) => {
    return {
        listWallet: state.walletReducer.listWallet,
        loading: state.walletReducer.loading
    }
}

const mapDispacthToProps = {
    getAllWallets,
    createWallet,
    deleteWallet
}

export default connect(mapStateProps, mapDispacthToProps)(Home);