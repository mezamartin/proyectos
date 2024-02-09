import React, {Component} from 'react';
import axios from 'axios';
import '../components/Register.css'
import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBCard, MDBCardBody } from 'mdbreact';


class Register extends Component{

    constructor(props) {
        super(props);
        this.state = {
            username:'',
            firstName:'',
            idCard:'',
            lastName:'',
            password:'',
        }
    }

    userChange = event => {
        this.setState({username: event.target.value});
    }

    firstNameChange = event => {
        this.setState({firstName: event.target.value});
    }

    idCardChange = event => {
        this.setState({idCard: event.target.value});
    }

    lastNameChange = event => {
        this.setState({lastName: event.target.value});
    }

    passwordChange = event => {
        this.setState({password: event.target.value});
    }

    componentDidMount() {
        axios.get("http://localhost:7000/users")
          .then(response => {
            console.log("GET USERS: ", response)
            this.setState({ users: response.data })
          })
          .catch(error => console.log("**** ERROR ****", error.toJSON()))
    }

    cancelRegister(e){
        e.preventDefault()
        this.props.history.push('/') 
    }

    handleSubmit = event => {
        event.preventDefault();

        const user = {
            email:this.state.username,
            firstName:this.state.firstName,
            idCard:this.state.idCard,
            lastName:this.state.lastName,
            password:this.state.password
        }

        axios.post("http://localhost:7000/register", user)
        .then(response => {
            console.log("REGISTER USER",response)
           console.log(response.data)
           this.props.history.push('/')
        })
    }

render(){
        return(
            <MDBContainer>
     <div className="login">
      <MDBRow>
        <MDBCol md="8">
          <MDBCard>
            <div className="header pt-3 grey lighten-2">
              <MDBRow className="d-flex justify-content-center">
                <h3 className="deep-grey-text mt-3 mb-4 pb-1 mx-5">
                  Digital Wallet - Registrarse
                </h3>
              </MDBRow>
            </div>
            <MDBCardBody className="mx-4 mt-4">
                <div className="form-group">
                    <label>Email:</label>
                    <input type="email" onChange={this.userChange} required className="form-control"/>
                    <br/>
                    <label>Nombre:</label>
                    <input type="text" onChange={this.firstNameChange} required className="form-control"/>
                    <br/>
                    <label>Apellido: </label>
                    <input type="text" onChange={this.lastNameChange} required className="form-control"/>
                    <br/>
                    <label>Id Card:</label>
                    <input type="number" onChange={this.idCardChange} required className="form-control"/>
                    <small className="form-text text-danger">{"id card 10 digitos"}</small>
                    <br/>
                    <label>Contraseña:</label>
                    <input type="password" onChange={this.passwordChange} required className="form-control"/>
                    <br/>                    
                </div>
                <div className="button">
                    <MDBBtn color="danger" onClick={(e) => this.cancelRegister(e)}>
                        Cancelar
                    </MDBBtn>
                    <MDBBtn color="success" type="submit" onClick={(e) => this.handleSubmit(e)}>
                        Aceptar
                    </MDBBtn>
                    </div>
              
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
      </div>
    </MDBContainer>
        );
    }
}
export default Register;