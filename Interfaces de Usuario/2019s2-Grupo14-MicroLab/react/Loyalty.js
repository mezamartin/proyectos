import React ,{ Component } from "react";
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBCollapse } from "mdbreact";
import axios from "axios";

class Loyalty extends Component{
    constructor(props){
        super(props)
        this.state = {
            collapseID: "",
            name:'',
            fromDate:'',
            toDate:'',
            amount:'',
            minTransaction:'',
            cantTransaction:''
        }
    }

    changeName = event =>{
      this.setState({name:event.target.value})
    }
    
    changeFromDate = event =>{
      this.setState({fromDate:event.target.value})
    }

    changeToDate = event =>{
      this.setState({toDate:event.target.value})
    }

    changeAmount = event => {
      this.setState({amount:event.target.value})
    }

    changeMinTransaction = event =>{
      this.setState({minTransaction:event.target.value})
    }

    changeCantTransaction = event =>{
      this.setState({cantTransaction:event.target.value})
    }

    
    toggleCollapse = collapseID => () => {
        this.setState(prevState => ({
          collapseID: prevState.collapseID !== collapseID ? collapseID : ""
        }));
    }
    backHome(){
        this.props.history.push('/home')
    }  

    componentDidMount(){
      axios.get("http://localhost:7000/loyalty/" + localStorage.getItem("userCvu"))
      .then(response => {
        console.log('beneficios del user: ',response.data)
      })
    }

    submitLoyaltyDiscount(e){
      const loyalty ={
          name:this.state.name,
          fromDate:this.state.fromDate,
          toDate:this.state.toDate,
          amount:this.state.amount,
          minTransaction:this.state.minTransaction,
          cantTransaction:this.state.cantTransaction,
      }
      e.preventDefault()
      axios.post("http://localhost:7000/loyaltyDiscount", loyalty)
      .then(response =>{
      })
    }

    submitLoyaltyGift(e){
      const loyalty ={
          name:this.state.name,
          fromDate:this.state.fromDate,
          toDate:this.state.toDate,
          amount:this.state.amount,
          minTransaction:this.state.minTransaction,
          cantTransaction:this.state.cantTransaction,
      }
      e.preventDefault()
      axios.post("http://localhost:7000/loyaltyGift", loyalty)
      .then(response =>{
      })
    }
    render(){
        return(
        <>
            <MDBBtn
              color="primary"
              onClick={this.toggleCollapse("descuento")}
              style={{ marginBottom: "1rem" }}
          >
            Beneficio: Descuento
          </MDBBtn>
          <MDBBtn
            color="primary"
            onClick={this.toggleCollapse("regalo")}
            style={{ marginBottom: "1rem" }}
          >
            Beneficio: Regalo
          </MDBBtn>
              <MDBCollapse id="descuento" isOpen={this.state.collapseID}>
              <div>
                <form
                className="needs-validation"
                onSubmit={(e) => this.submitLoyaltyDiscount(e)}
                >
            <MDBRow>
            <MDBCol md="4">
              <MDBInput
                value={this.state.name}
                name="name"
                onChange={this.changeName}
                type="text"
                id="materialFormRegisterNameEx"
                label="Nombre"
                required
              >
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.fromDate}
                name="fromDate"
                onChange={this.changeFromDate}
                type="text"
                id="materialFormRegisterEmailEx2"
                label="Fecha Desde"
                required
              >
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
              <small className="form-text text-danger">{"dd/mm/yy"}</small> 
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.toDate}
                onChange={this.changeToDate}
                type="text"
                id="materialFormRegisterConfirmEx3"
                name="toDate"
                label="Fecha Hasta"
              >
                <small id="emailHelp" className="form-text text-muted">
                  
                </small>
              </MDBInput>
              <small className="form-text text-danger">{"dd/mm/yy"}</small>
            </MDBCol>
            </MDBRow>
            <MDBRow>
            <MDBCol md="4">
              <MDBInput
                value={this.state.amount}
                onChange={this.changeAmount}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="amount"
                label="Descuento"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid city.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.minTransaction}
                onChange={this.changeMinTransaction}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="minTransaction"
                label="Transaccion minima"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid state.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.cantTransaction}
                onChange={this.changeCantTransaction}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="cantTransaction"
                label="Cantidad de Trasacciones"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid zip.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            </MDBRow>
            <MDBBtn color="success" type="submit" onClick={(e)=>this.submitLoyaltyDiscount(e)}>
                Aplicar
            </MDBBtn>
            </form>
            </div>
              </MDBCollapse>
              <MDBCollapse id="regalo" isOpen={this.state.collapseID}>
              <div>
                <form
                className="needs-validation"
                onSubmit={(e) => this.submitLoyaltyGift(e)}
                >
            <MDBRow>
            <MDBCol md="4">
              <MDBInput
                value={this.state.name}
                name="name"
                onChange={this.changeName}
                type="text"
                id="materialFormRegisterNameEx"
                label="Nombre"
                required
              >
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.fromDate}
                name="fromDate"
                onChange={this.changeFromDate}
                type="text"
                id="materialFormRegisterEmailEx2"
                label="Fecha Desde"
                required
              >
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
              <small className="form-text text-danger">{"dd/mm/yy"}</small>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.toDate}
                onChange={this.changeToDate}
                type="text"
                id="materialFormRegisterConfirmEx3"
                name="toDate"
                label="Fecha Hasta"
              >
                <small id="emailHelp" className="form-text text-muted">
                  
                </small>
              </MDBInput>
              <small className="form-text text-danger">{"dd/mm/yy"}</small>
            </MDBCol>
            </MDBRow>
            <MDBRow>
            <MDBCol md="4">
              <MDBInput
                value={this.state.amount}
                onChange={this.changeAmount}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="amount"
                label="Regalo"
                required
              >
                <div className="invalid-feedback">
                  
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.minTransaction}
                onChange={this.changeMinTransaction}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="minTransaction"
                label="Transaccion minima"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid state.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.cantTransaction}
                onChange={this.changeCantTransaction}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="cantTransaction"
                label="Cantidad de Transacciones"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid zip.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            </MDBRow>
            <MDBBtn color="success" type="submit" onClick={(e)=>this.submitLoyaltyGift(e)}>
                Aplicar
            </MDBBtn>
            </form>
            </div>
              </MDBCollapse>
              <MDBBtn
                color="unique"
                onClick={() => this.backHome()}
                style={{ marginBottom: "1rem" }}>
                    Atras
          </MDBBtn>
          
        </>
        
            
          );
        }    
    
}
export default Loyalty;