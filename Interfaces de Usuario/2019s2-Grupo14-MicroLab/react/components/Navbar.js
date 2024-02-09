import React, {Component} from 'react';
import { Navbar, Nav, Form} from 'react-bootstrap';
import { withRouter } from 'react-router-dom';


class NavbarNav extends Component {
  constructor(props){
    super(props)
    this.state = {
      userLogged:'',
      userAccount:''
    }
  }

  renderCashOut(){
    this.props.history.push('/cashOut')
  }

  renderProfile(){
    this.props.history.push('/profile')
  }

  renderLogOut(){
    //localStorage.removeItem("userEmail")
    //localStorage.removeItem("userCvu")
    //localStorage.removeItem("userLogged")
    this.props.history.push('/')
  }

  renderCashIn(){
    this.props.history.push('/cashIn')
  }
  renderLoyalty(){
    this.props.history.push('/loyalty')
  }
   
    render() {
        return (
          <>
  <Navbar bg="light" variant="light">
    <Navbar.Brand >Digital Wallet</Navbar.Brand>
    <Nav className="mr-auto">
      <Nav.Link onClick={()=> this.renderCashIn()}>Ingresar Dinero</Nav.Link>
      <Nav.Link onClick={()=> this.renderCashOut()}>Transferir Dinero</Nav.Link>
      <Nav.Link onClick={()=> this.renderProfile()}>Perfil</Nav.Link>
      <Nav.Link onClick={()=> this.renderLoyalty()}>Beneficios</Nav.Link>
    </Nav>
    <Form inline>
      <Navbar.Collapse className="justify-content-end">
        <Nav.Link
          onClick={()=> this.renderLogOut()}>LogOut
        </Nav.Link>
      </Navbar.Collapse>
      
    </Form>
  </Navbar>
</>
        )
    }
};

export default withRouter(NavbarNav)

