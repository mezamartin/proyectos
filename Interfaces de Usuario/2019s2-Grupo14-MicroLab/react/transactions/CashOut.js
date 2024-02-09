import React ,{ Component } from "react";
import axios from "axios";
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBCollapse } from "mdbreact";
import '../transactions/CashOut.css'
import Navbar from "../components/Navbar.js"

class CashOut extends Component{
    constructor(props){
        super(props)
        this.state = {
            toCvu:'',
            amount:'',
            userLogged:'',
            userAccount:'',
            error:''
        }
    }

    
    toChange = event =>{
        this.setState({toCvu:event.target.value})
    }
    
    amountChange = event =>{
        this.setState({amount:event.target.value})
    }
    
    acceptTransfer(e){
        e.preventDefault()
        const transfer = {
            fromCVU:localStorage.getItem("userCvu"),
            toCVU:this.state.toCvu,
            amount:this.state.amount
        } 
        axios.post("http://localhost:7000/transfer", transfer)
        .then(response =>{
            console.log(response.data)
            this.props.history.push('/home')

        })
        .catch(error =>{
            console.log('error:', error.request.response)
            //alert(response.message.errorMessage)    
        })
    }

    componentDidMount() {
        axios.get("http://localhost:7000/accounts")
        .then(response => {
            console.log("GET ACCOUNTS: ", response)
            
        })
      }

    cancelTransfer(e){
        e.preventDefault()
        this.props.history.push('/home') 
    }
    
    render(){
        return(
        <div>
            <Navbar/>
            <form
                className="cashOut"
                onSubmit={(e) => this.acceptTransfer(e)}>
                
                <MDBRow className="title">
                <h3 className="deep-grey-text mt-3 mb-4 pb-1 mx-5">
                  Digital Wallet - Transferencias
                </h3>
              </MDBRow>
                <MDBRow className="body" >
                <MDBCol md="3">
                <MDBInput
                    value={this.state.toCvu}
                    name="toCvu"
                    onChange={this.toChange}
                    type="text"
                    id="materialFormRegisterNameEx"
                    label="Cvu destinatario"
                    required
                >
                <div className="valid-feedback">Looks good!</div>
                </MDBInput>
                <small className="form-text text-danger">{"Ingresar 9 digitos"}</small>
                </MDBCol>
                <MDBCol md="3">
                <MDBInput
                    value={this.state.fromDate}
                    name="amount"
                    onChange={this.amountChange}
                    type="text"
                    id="materialFormRegisterEmailEx2"
                    label="Cantidad"
                    required
                >
                <div className="valid-feedback">Looks good!</div>
                </MDBInput>
                </MDBCol>
                </MDBRow>
                <div className="button">
                <MDBBtn color="danger" onClick={(e) => this.cancelTransfer(e)}>
                    Cancelar
                </MDBBtn>
                <MDBBtn color="success" type="submit" onClick={(e) => this.acceptTransfer(e)}>
                    Aceptar
                </MDBBtn>
                </div>
            </form>
        </div>        
        )
    }
}
export default CashOut;