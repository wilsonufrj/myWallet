import { Button } from 'primereact/button';
import { PanelMenu } from 'primereact/panelmenu';
import { useEffect, useState } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { SideBarData } from '../utils/ListToSidebar';
import { getAllWallets } from '../../../actions/actionWallet';
import './style.css'

function Sidebar(props){

    const [listWallet,setListWallet] = useState([])

     useEffect(()=>{
        if(props.listWallet.length == 0){
            props.getAllWallets();
        }
        setListWallet(SideBarData(props.listWallet))
    },[props.listWallet])

    return(
        <div className="sidebar">
            
            <div className='headSidebar'>
                <h1>My Wallet</h1>
            </div>
            <div>
                
            </div>
            <Link to="/">
                <Button> Voltar</Button>
            </Link>
            <div className='listMonths'>
                {props.loading?
                    'LOADING':
                    <PanelMenu model={listWallet}/>
                }
                 
            </div>
            
        </div>
    )
}

const mapStateProps = (state)=>{
    return({
        listWallet: state.walletReducer.listWallet,
        loading: state.walletReducer.loading
    })
}

const mapDispacthToProps = {
    getAllWallets,
}

export default connect(mapStateProps,mapDispacthToProps)(Sidebar);