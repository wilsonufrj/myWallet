import DataTableGanhos from "../../../components/DataTableGanhos";
import DataTableGastos from "../../../components/DataTableGastos";

declare interface IProspPlanilhas {
    dadosGanhos: any
    dadosGastos: any
}

const Planilhas = (props: IProspPlanilhas) => {
    return (
        <div className="grid">
            <div className="col-12">
                <DataTableGanhos titulo="Ganhos" transacoes={props.dadosGanhos} />
            </div>
            <div className="col-12">
                <DataTableGastos titulo="Gastos" transacoes={props.dadosGastos} />
            </div>
        </div>
    )
}

export default Planilhas;