import React, { useState } from 'react';
import { Sidebar } from 'primereact/sidebar';
import { Button } from 'primereact/button';

function SideBar() {
    const [visibleLeft, setVisibleLeft] = useState(true);

    return(
        <div style={{border:'1px black solid',width:'100%',height:'100'}}>
            <div className="card">
                <Sidebar visible={visibleLeft} onHide={() => setVisibleLeft(false)}>
                    <h3>Left Sidebar</h3>
                </Sidebar>

                

                <Button icon="pi pi-arrow-right" onClick={() => setVisibleLeft(true)} className="mr-2" />
                <h1>ola</h1>
            </div>
            
        </div>
    )
}

export default SideBar;