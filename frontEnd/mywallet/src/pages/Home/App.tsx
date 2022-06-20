import Footer from "../components/footer/App";
import "./style.css";

import { Card } from 'primereact/card';
import { Link} from "react-router-dom";
import { Button } from "primereact/button";

function Home() {
    const months:Array<String> = ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]

    const intoMonth=()=>{
        console.log()
        
    }

    return(
        <div>
            <h1 className="title">Bem vindo ao myWallet</h1>
            <div className="mainContainer">
                <div  className="months">

                    {
                       months.map((value,index)=>{
                           return(
                                <Card key={index} title={value}>
                                    <Link to="/month/">
                                        <Button onClick={intoMonth}> Acessar</Button>
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

export default Home;