import React, {Component} from 'react'
import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBCard, MDBCardBody } from 'mdbreact';
import axios from 'axios';


import './Login.css'



class Login extends Component{

    constructor(props) {
        super(props);
        let loggedIn = false
        this.state = {
            email:'',
            password:'',
            error:'',
            loggedIn,
            users:[],
            userLogged:'',
        }
        this.onChange = this.onChange.bind(this)
        this.submitForm = this.LoginForm.bind(this)
    }
    
onChange(e){
    this.setState({
        [e.target.name]:e.target.value
    })
}

LoginForm(e){
    e.preventDefault()
    const login = {
      email:this.state.email,
      password:this.state.password
    }
    axios.post("http://localhost:7000/login", login)
      .then(response => {
        console.log("Login Success",response)
        this.getUserLogged()
        this.props.history.push('/home')
      })
      .catch(error =>{
        console.log(error.response.data)
        this.setState({error:error.response.data.message})
      })

  }
  
  RegisterForm(e){
    e.preventDefault()
    this.props.history.push('/register')
  }

componentDidMount() {
  axios.get("http://localhost:7000/users")
    .then(response => {
      console.log("GET USERS: ", response)
      this.setState({ users: response.data })
    })
    .catch(error => console.log("**** ERROR ****", error.toJSON()))
}


getUserLogged(){
  axios.get("http://localhost:7000/users/" + this.state.email)
    .then(response => {
      this.setUser(response.data)
    })
}

setUser = (user) => {
  this.props.setUser(user)
}

render(){
   return(
  
   <MDBContainer>
     <div className="login">
      <MDBRow>
        <MDBCol md="6">
          <MDBCard>
            <div className="header pt-3 grey lighten-2">
              <MDBRow className="d-flex justify-content-center">
                <h3 className="deep-grey-text mt-3 mb-4 pb-1 mx-5">
                  Digital Wallet - Login
                </h3>
              </MDBRow>
            </div>
            <MDBCardBody className="mx-4 mt-4">
                <div className="form-group">
                    
                    <input 
                        placeholder="Email" 
                        className={`form-control ${this.state.error && 'is-invalid'}`} 
                        value={this.state.email} 
                        onChange={(ev) => this.setState({ email: ev.target.value, error: '' })} />
                        {this.state.error && <small className="form-text text-danger">{this.state.error}</small>}
                
                    <br/>
                    <input
                        type="password"
                        placeholder="Password"
                        className={`form-control ${this.state.error && 'is-invalid'}`}
                        value={this.state.password}
                        onChange={(ev) => this.setState({ password: ev.target.value, error: '' })}
                        containerClass="mb-0"
                    />
                </div>
                <div className="text-center mb-4 mt-5">
                <MDBBtn
                  color="danger"
                  type="button"
                  className="btn-block z-depth-2"
                  onClick={(e)=> this.LoginForm(e)}
                >
                  Log in
                </MDBBtn>
                <MDBBtn
                  background="green"
                  type="button"
                  className="btn-block z-depth-2"
                  onClick={(e)=> this.RegisterForm(e)}
                >
                  Registrarse
                </MDBBtn>
              </div>
              
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
      </div>  
    </MDBContainer>
    
   )
};
}


export default Login;