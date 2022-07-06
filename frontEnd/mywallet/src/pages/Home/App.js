import Footer from "../components/footer/App";
import "./style.css";

import { Card } from 'primereact/card';
import { Link} from "react-router-dom";
import { Button } from "primereact/button";
import { Dialog } from 'primereact/dialog';

import {connect} from 'react-redux'
import { bindActionCreators } from 'redux'
import { createWallet, getAllWallets } from "../../actions/actionWallet";
import { useEffect, useState } from "react";



function Home(props) {
    const [displayResponsive, setDisplayResponsive] = useState(false);
    const [position, setPosition] = useState('center');
    useEffect(()=>{
       props.getAllWallets()
    },[])

    
    const renderFooter = (name) => {
        return (
            <div>
                <Button label="No" icon="pi pi-times" onClick={() => onHide(name)} className="p-button-text" />
                <Button label="Yes" icon="pi pi-check" onClick={() => onHide(name)} autoFocus />
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
            <div className="mainContainer">
                <Button onClick={()=>
                {
                    onClick('displayResponsive')
                    // props.createWallet()
                }
                }>Nova Carteira</Button>
                <Dialog header="Header" visible={displayResponsive} onHide={() => onHide('displayResponsive')} breakpoints={{'960px': '75vw'}} style={{width: '50vw'}} footer={renderFooter('displayResponsive')}>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                        cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </Dialog>
                <div  className="months">
                    {
                        props.loading?"LOADING":
                        props.listWallet.map((value,index)=>{
                            return(
                                <Card key={index} title={value.name}>
                                    <Link to="/month/" state={value}>
                                        <Button> Acessar</Button>
                                    </Link>
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
        listWallet:state.listWallet,
        loading:state.loading
    }
}

const mapDispacthToProps  = {
        getAllWallets,
        createWallet
}

export default connect(mapStateProps,mapDispacthToProps)(Home);