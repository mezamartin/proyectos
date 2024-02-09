import React, {Component} from 'react';
import axios from 'axios';
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBCollapse } from "mdbreact";
import Navbar from './Navbar'

class CashIn extends Component{
    constructor(props){
        super(props)
        this.state ={
            amount : '',
            cardNumber : '',
            fullName : '',
            securityCode : '',
            endDate: '',
            userLogged : '',
            userAccount: ''
        }
    }

    setUser = (user) =>{
        this.state({
          userLogged:user
        })
      }

    
    amountChange = event =>{
        this.setState({amount:event.target.value})
    }

    cardNumberChange = event =>{
      this.setState({cardNumber:event.target.value})
    }

    fullNameChange = event =>{
        this.setState({fullName:event.target.value})
    }

    securityCodeChange = event =>{
      this.setState({securityCode: event.target.value})
    }

    endDateChange = event =>{
      this.setState({endDate: event.target.value})
    }


    acceptCashIn(e){
        e.preventDefault()
        const ch = {
          fromCVU:localStorage.getItem("userCvu"),
          amount:this.state.amount,
          cardNumber:this.state.cardNumber,
          fullName: this.state.fullName,
          securityCode: this.state.securityCode,
          endDate: this.state.endDate
        }
        axios.post("http://localhost:7000/cashIn", ch)
          .then(response => {
            console.log("CashIn Success",response)
            this.props.history.push('/home')
          })
          /*.catch(error =>{
            console.log(error.response.data)
            this.setState({error:error.response.data.message})
          })*/
    
      }


      componentDidMount() {
        axios.get("http://localhost:7000/accounts")
        .then(response => {
          console.log("GET ACCOUNTS: ", response)
          this.setState({ accounts: response.data })
          console.log('cuentas: ' ,this.state.accounts)
          console.log('cvu user',localStorage.getItem("userCvu"))
        })
      }

      cancelCashIn(e){
        e.preventDefault()
        this.props.history.push('/home') 
    }

   /* render(){
        return(
            <div className = 'cashIn'>
                <Navbar/>
                <div className='titulocashIn'>
                    <h1>Cash In</h1>
                </div>
                <div className='inputAmount'>
                   <label>Amount</label>
                   <br></br>
                   <input onChange={this.amountChange}></input> 
                </div>
                <div className='inputRadio'>
                    <form>
                        <input type="radio" name="tipoTarjeta" value="creditCard"checked={true}/>Credit Card
                        <input type="radio" name="tipoTarjeta" value="debitCard"/>Debit Card
                    </form>
                </div>
                <div>
                    <label>Card Number</label>
                    <br></br>
                    <input onChange={this.cardNumberChange}></input>
                </div>
                <div>
                    <label>Full Name</label>
                    <br></br>
                    <input onChange={this.fullNameChange}></input>
                </div>
                <div>
                    <span>
                        <label>Security Code</label>
                        <label>End Date</label>
                        <br></br>
                    </span>
                    <span>      
                        <input onChange={this.securityCodeChange}></input>
                        <input onChange={this.endDateChange}></input>
                    </span>
                </div>
                <div>
                    <span>
                        <button type="button"onClick={(e) => this.cancelCashIn(e)}>Cancel</button>
                        <button type="button" onClick={(e)=> this.acceptCashIn(e)}>Confirm</button>
                    </span>
                    
                </div>
                
                
            </div>
        );
    }
}*/

render(){
  return(
    <>
    <Navbar/>
    <MDBRow>
            <MDBCol md="4">
              <MDBInput
                value={this.state.amount}
                name="name"
                onChange={this.amountChange}
                type="text"
                id="materialFormRegisterNameEx"
                label="Saldo"
                required
              >
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.cardNumber}
                name="fromDate"
                onChange={this.cardNumberChange}
                type="text"
                id="materialFormRegisterEmailEx2"
                label="Numero de Tarjeta"
                required
              >
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
              <small className="form-text text-danger">{"Deben ser 16 digitos"}</small>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.fullName}
                onChange={this.fullNameChange}
                type="text"
                id="materialFormRegisterConfirmEx3"
                name="toDate"
                label="Nombre Completo"
              >
                <small id="emailHelp" className="form-text text-muted">
                  
                </small>
              </MDBInput>
            </MDBCol>
            </MDBRow>
            <MDBRow>
            <MDBCol md="4">
              <MDBInput
                value={this.state.securityCode}
                onChange={this.securityCodeChange}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="amount"
                label="Codigo de Seguridad"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid city.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
              <small className="form-text text-danger">{"Ingresar 3 digitos"}</small>
            </MDBCol>
            <MDBCol md="4">
              <MDBInput
                value={this.state.endDate}
                onChange={this.endDateChange}
                type="text"
                id="materialFormRegisterPasswordEx4"
                name="minTransaction"
                label="Fecha Hasta"
                required
              >
                <div className="invalid-feedback">
                  Please provide a valid state.
                </div>
                <div className="valid-feedback">Looks good!</div>
              </MDBInput>
              <small className="form-text text-danger">{"Debe estar en formato dd/mm/yyyy"}</small>
            </MDBCol>
            </MDBRow>
            <span>
              <button type="button"onClick={(e) => this.cancelCashIn(e)}>Cancelar</button>
              <button type="button" onClick={(e)=> this.acceptCashIn(e)}>Confirmar</button>
            </span>
            </>
  );
  }
}
export default CashIn;