import { TabPanel, TabView } from "primereact/tabview";
import Balanco from "./Mes/Balanco";
import Planilhas from "./Mes/Planilhas";
import { useSelector } from "react-redux";
import { RootState } from "../../redux/store";



const Home = () => {

    const dados= useSelector((state:RootState)=> state.home)
    
    return (
        <div className="p-4">
            <div id="Title">
                <div className="flex justify-content-center font-bold text-5xl m-5">
                    <span>{dados?.nomeMes}</span>
                </div>
                <TabView>
                    <TabPanel header="Balanço" leftIcon="pi pi-calculator m-2">
                        <Balanco ganhosMes={dados?.balanco?.ganhosMes}
                            gasto={dados?.balanco?.gasto}
                            saldoAtual={dados?.balanco?.saldoAtual}
                            saldoInvestimentoMes={dados?.balanco?.saldoInvestimentoMes}
                            saldoMesSeguinte={dados?.balanco?.saldoMesSeguinte} />
                    </TabPanel>
                    <TabPanel header="Planilhas" leftIcon="pi pi-money-bill m-2">
                        <Planilhas dadosGanhos={dados?.planilhas?.ganhos}
                            dadosGastos={dados?.planilhas?.gastos}
                            dadosInvestimento={dados?.planilhas?.investimentos} />
                    </TabPanel>
                </TabView>
            </div>
        </div>
    )
}

export default Home;