import {connect} from 'react-redux'
import { Button } from "primereact/button";
import { useEffect } from "react";
import { getWalletData } from "../actions/actionMonth";


const Teste = (props)=>{

    useEffect(()=>{
        console.log(props.getWalletData(9))
    },[])

    const printaProps = ()=>{
        console.log(props);
    }

    return(
        <div>
            <Button onClick={printaProps}>CLICK</Button>
        </div>
    )
}

const mapStatetoProps = (state)=>{
    return{
        name:state.monthReducer.name
    }
}

const mapDispacthToProps = {
    getWalletData,
}

export default connect(mapStatetoProps,mapDispacthToProps)(Teste);