import { Link } from 'react-router-dom';

export const SideBarData = (listWallet)=>{
    let dataSidebar = []

    listWallet.map((value,index)=>{
        dataSidebar.push({
            label:value.name,
            items:[{
                id:value.id,
                icon:'pi pi-chart-bar',
                template:(item,options)=>{
                    return(        
                        <Link to={`/month/${item.id}`}>
                            <div id="itensSidebar">
                                <span className={item.icon}></span>
                                <span>Overview</span>
                            </div>
                        </Link>
                        
                    )
                }
            },{
                label:'Historico Transaction',
                icon:'pi pi-fw pi-external-link',
                id:value.id,
                template: (item, options) => {
                    return(  
                                
                        <Link to={`/historical/${item.id}`}>
                            <div id="itensSidebar">
                                <span className={item.icon}></span>
                                <span>Historical</span>
                            </div>
                        </Link>
                        
                    )
                }
            }
            ]

        })
    })

    return dataSidebar;
}