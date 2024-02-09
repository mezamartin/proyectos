import React ,{ Component } from "react";
import Navbar from './components/Navbar'
import axios from "axios";
import './Profile.css'
import { MDBRow, MDBCol, MDBInput, MDBBtn, MDBCollapse, MDBCard, MDBCardBody} from "mdbreact";

class Profile extends Component{
    
    constructor(props){
        super(props)
        this.state = {
        firstName: '',
        lastName: '',
        email: '',
        cvu: '',
        amount: '',
        userLogged: ''
        }
      }

    
    firstNameChange = event => {
        this.setState({firstName: event.target.value});
    }

    lastNameChange = event => {
        this.setState({lastName: event.target.value});
    }

    emailChange = event => {
        this.setState({email: event.target.value});
    }

    setAccount(account){
        this.setState({
          accountUser:account})
          this.props.setAccount(account)
    }

    getUserAccount(){
        axios.get("http://localhost:7000/accounts/" + localStorage.getItem("userCvu"))
        .then(response => {
            console.log("GET AMOUNT WITH CVU:", localStorage.getItem("userCvu"))
            this.setState({ cvu:response.data.cvu,amount:response.data.amount})
          })
        .catch(function (error) {
            console.log('error is ',error);
          });
    }

    componentDidMount(){
        axios.get("http://localhost:7000/users/" + localStorage.getItem("userEmail"))
        .then(response => {
            console.log("GET USER WITH EMAIL: ", response)
            this.setState({ firstName: response.data.firstName,lastName: response.data.lastName,email: response.data.email})
            this.getUserAccount()
          })
        .catch(function (error) {
            console.log('error is ',error);
          });
    }

    handleSubmit = event => {
        event.preventDefault();
        axios.get("http://localhost:7000/users/" + localStorage.getItem("userEmail"))
        .then(response => {
            console.log("GET USER",response)
           console.log(response.data)
            this.newUser(response.data)
           this.props.history.push('/home')
        })
    }

   newUser(data){
    const user = {
        email:this.state.email,
        firstName:this.state.firstName,
        lastName:this.state.lastName
    }
    axios.patch("http://localhost:7000/users/" + localStorage.getItem("userEmail"),user)
    .then(response => {
        console.log("UPDATE USER",response)
        this.setUser(response.data)

    })
   }

   setUser = (user) => {
    this.props.setUser(user)
  }

   cancelProfile(e){
    e.preventDefault()
    this.props.history.push('/home')
   }

    render(){
        return(
            <div>
            <Navbar/>
            <form className="profile">  
            <MDBCol md="20">              
                <MDBRow className="title">
                <h3 className="deep-grey-text mt-3 mb-4 pb-1 mx-5">
                  Digital Wallet - Perfil
                </h3>
              </MDBRow>
                <MDBRow className="body" >
                <MDBCol md="3">
                </MDBCol>
                <MDBCol md="3">
                <MDBInput
                    value={this.state.firstName}
                    name="firstName"
                    onChange={this.firstNameChange}
                    type="text"
                    label="First Name">
                </MDBInput>
                </MDBCol>
                </MDBRow>
                <MDBRow className="body" >
                <MDBCol md="3">
                </MDBCol>
                <MDBCol md="3">
                <MDBInput
                    value={this.state.firstName}
                    name="lastName"
                    onChange={this.lastNameChange}
                    type="text"
                    label="Last Name">
                </MDBInput>
                </MDBCol>
                </MDBRow>
                <MDBRow className="body" >
                <MDBCol md="3">
                </MDBCol>
                <MDBCol md="3">
                <MDBInput
                    value={this.state.email}
                    name="email"
                    onChange={this.emailChange}
                    type="email"
                    label="Email">
                </MDBInput>
                </MDBCol>
                </MDBRow>
                <MDBRow className="body" >
                <MDBCol md="3">
                </MDBCol>
                <MDBCol md="3">
                <MDBInput
                    value={this.state.cvu}
                    name="lastName"
                    label="CVU">
                </MDBInput>
                </MDBCol>
                </MDBRow>
                <MDBRow className="body" >
                <MDBCol md="3">
                </MDBCol>
                <MDBCol md="3">
                <MDBInput
                    value={this.state.amount}
                    name="amount"
                    label="Amount">
                </MDBInput>
                </MDBCol>
                </MDBRow>
                <div className="button">
                <MDBBtn color="danger" onClick={(e) => this.cancelProfile(e)}>
                    Cancelar
                </MDBBtn>
                <MDBBtn color="success" type="submit" onClick={(e) => this.handleSubmit(e)}>
                    Aceptar
                </MDBBtn>
                </div>
                </MDBCol>
            </form>
            </div>
        );
        }
}
export default Profile;