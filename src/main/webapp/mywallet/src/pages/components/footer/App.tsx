function Footer() {

    var wilson = {
        backgroundColor: "#000",
        textAlign: "center" as "center",
        position: "fixed" as "fixed",
        left: "0",
        bottom: "0",
        height: "40px",
        width: "100%",
        color:"#FFF"
    }

    var phantom = {
        display: 'block',
        width: '100%',
      }

 return(
    <div style={phantom}>
        <div style={wilson}>
            <h3>Feito by Wilson</h3>
        </div>
        
    </div>
    )   
}

export default Footer