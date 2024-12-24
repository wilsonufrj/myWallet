import DataTableGanhos from "../../../components/DataTableGanhos";
import DataTableGastos from "../../../components/DataTableGastos";

declare interface IProspPlanilhas {
    dadosGanhos: any
    dadosGastos: any
    dadosInvestimento: any
}

const Planilhas = (props:IProspPlanilhas) => {

    const dadosGanhos =props.dadosGanhos;
    const dadosInvestimento = props.dadosInvestimento;
    const dadosGastos = props.dadosGastos;

    return (
        <div className="grid">
            <div className="col-6">
                <DataTableGanhos titulo="Ganhos" transacoes={dadosGanhos}/>
            </div>
            <div className="col-6">
                <DataTableGanhos titulo="Investimento" transacoes={dadosInvestimento} />
            </div>
            <div className="col-12">
                <DataTableGastos titulo="Gastos" transacoes={dadosGastos}/>
            </div>
        </div>
    )
}

export default Planilhas;