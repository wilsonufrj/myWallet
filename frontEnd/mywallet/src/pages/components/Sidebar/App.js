import { Button } from 'primereact/button';
import { PanelMenu } from 'primereact/panelmenu';
import { Link } from 'react-router-dom';
import './style.css'

function Sidebar(){
    const items = [
        {
            label:'Junho',
            items:[
                {
                    label:'Overview',
                    id:17,
                    icon:'pi pi-fw pi-trash',
                    template: (item, options) => {
                        
                        return(              
                                <Link to={`/month/17`}>
                                    <div id="testeLabel">
                                        <span className='pi pi-chart-bar'></span>
                                        <span>Overview</span>
                                    </div>
                                </Link>
                        )
                    }
                },
                {
                    label:'Historico Transaction',
                    icon:'pi pi-fw pi-external-link',
                    url:'/historical/17',
                    template: (item, options) => {
                        return(              
                            <Link to={`/historical/17`}>
                                <div id="testeLabel">
                                    <span className='pi pi-fw pi-external-link'></span>
                                    <span>Historical</span>
                                </div>
                            </Link>
                    )
                    }
                }
            ]
        }
    ];

    const RedirectTeste = (id)=>{
        return(
            <>
                <Link to={`/historical/${id}`}>
                    <li className='p-menuitem'>
                        <span className='p-menuitem-icon pi pi-fww pi-trah'></span>
                        <span className='p-menuitem-text'>Overview</span>
                    </li>
                </Link>
            </>
        )
    }

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
                 <PanelMenu model={items}/>
            </div>
            
        </div>
    )
}

export default Sidebar;