import { Dialog } from "primereact/dialog";

const Modal = (props)=>{
    return(
        <Dialog header="Transaction"
                        visible={displayResponsive}
                        onHide={() => onHide('displayResponsive')}
                        style={{width: '50vw'}}
                        footer={renderFooter('displayResponsive')}>

            <InputText placeholder="Name" htmlFor="nawWallet"/>
        </Dialog>
    );

}

export default Modal;