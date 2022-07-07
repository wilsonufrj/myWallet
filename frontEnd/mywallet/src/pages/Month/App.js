import { useEffect, useState } from 'react';
import { useParams} from 'react-router-dom';
import "./style.css";
import { Card } from 'primereact/card';
// import { ITransactionDTO } from '../../Data/ITransaction';

import {connect} from 'react-redux'
import { loadData } from '../../actions/actionTransaction';
import Sidebar from '../components/Sidebar/App';
import ChartPie from '../components/chartPie/App'
import ChartGraph from '../components/chartGraph/App';



function Month(props) {
    const idURL = useParams()

    useEffect(()=>{
        props.loadData(idURL.monthId)
    },[])


    return(
        <div >
            <Sidebar/>
            <div className='mainContainer'>
                <h1 id="titleMonth">{props.nameWallet}</h1>
                <div className='dataRow'>
                    <Card title="Ganho Total">
                        <div className='bodyInformation'>
                            <span className='moneyFormat'>{`R$${props.allMoney}`}</span>
                        </div>
                    </Card>
                    <Card title="Total Gasto Crédito">
                        <div className='bodyInformation'>
                            <span className='moneyFormat'>R$300,00</span>
                        </div>
                    </Card>
                    <Card title="Total Gasto Débito">
                        <div className='bodyInformation'>
                            <span className='moneyFormat'>R$150,00</span>
                        </div>
                    </Card>
                 
                </div>
                <div className='dataRowGraph'>
                    <div>
                        <Card>
                            <ChartPie/>
                        </Card>
                    </div>
                    <div>
                        <Card>
                            <ChartGraph/>
                        </Card>
                    </div>
                </div>
            </div>
        </div>
    )
}

const mapStatetoProps =(state)=>{
    return{
        allMoney:state.transactionReducer.allMoney,
        loading:state.transactionReducer.loading,
        listTransaction:state.transactionReducer.listTransaction,
        nameWallet:state.transactionReducer.name
    }
}

const mapDispacthToProps = {
    loadData,
}

export default connect(mapStatetoProps,mapDispacthToProps)(Month);