import Footer from "../components/footer/App";
import "./style.css";

import { Card } from 'primereact/card';
import { Link} from "react-router-dom";
import { Button } from "primereact/button";
import { Dialog } from 'primereact/dialog';

import {connect} from 'react-redux'
import { createWallet, getAllWallets, deleteWallet } from "../../actions/actionWallet";
import { useEffect, useState } from "react";
import { InputText } from "primereact/inputtext";



function Home(props) {
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [position, setPosition] = useState('center');
    const [nameNewWallet,setNameNewWallet] = useState({name:""})

    useEffect(()=>{
       props.getAllWallets()
    },[])

    const renderFooter = (name) => {
        return (
            <div>
                <Button label="Cancelar" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Salvar" icon="pi pi-check" onClick={() =>{
                     onHide(name)
                     props.createWallet(nameNewWallet)
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
    return(
        <div>
            <h1 className="title">Bem vindo ao myWallet</h1>
            <div className="mainContainerHome">
                <Button onClick={()=> onClick('displayResponsive')}>Nova Carteira</Button>
                <Dialog header="Nova Carteira" visible={displayResponsive} onHide={() => onHide('displayResponsive')} breakpoints={{'960px': '75vw'}} style={{width: '50vw'}} footer={renderFooter('displayResponsive')}>
                    <InputText placeholder="Name" htmlFor="nawWallet" onChange={(e)=>setNameNewWallet(e.target.value)}/>
                </Dialog>
                <div  className="months">
                    {
                        props.loading?"LOADING":
                        props.listWallet.map((value,index)=>{
                            return(
                                <Card key={index} title={value.name} subTitle={value.allMoney}>
                                    <Link to={`/month/${value.id}`}>
                                        <Button>Acessar</Button>
                                    </Link>
                                    {/* Deixar o botao escondido por enquanto */}
                                    {/* <Button icon="pi pi-trash" iconPos="right" label="Deletar" className="p-button-danger" onClick={()=>props.deleteWallet(value.id)}></Button> */}
                                </Card>
                            )
                        })
                    }
                </div>
            </div>
        </div>
    )
}

const mapStateProps = (state)=>{
    return{
        listWallet:state.walletReducer.listWallet,
        loading:state.walletReducer.loading
    }
}

const mapDispacthToProps  = {
        getAllWallets,
        createWallet,
        deleteWallet
}

export default connect(mapStateProps,mapDispacthToProps)(Home);