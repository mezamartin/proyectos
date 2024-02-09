import React, {Component} from 'react';
import logo from './logo.svg';
import Login from './Login.js';
import Home from './Home.js';
import Profile from './Profile.js';
import Register from './components/Register'
import CashIn from './components/CashIn'
import CashOut from './transactions/CashOut'
import './App.css';
import {BrowserRouter,Switch,Route} from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar } from 'react-bootstrap';
import Loyalty from './Loyalty.js'

class App extends Component{
  constructor(props){
    super(props)
    this.state = {
      userLogged:'',
      userAccount:''
    }
  }
    
setUser = (user) => {
  this.setState({
      userLogged: user
  })
  localStorage.setItem("userLogged",user)
  localStorage.setItem("userEmail",user.email)
}

setAccount = (acc) => {
  this.setState({
    userAccount:acc
  })
  localStorage.setItem("userCvu",acc.cvu)
}

  render(){
    return(
      <BrowserRouter>
        <Switch>
    <Route exact path="/" render= {(props) => <Login {...props} setUser={this.setUser}/>}/>
          <Route path ="/register" component={Register}/>
          <Route path="/home" render= {(props) => <Home {...props} userAccount={this.state.userAccount} userLogged={this.state.userLogged}
                                                    setAccount={this.setAccount} setUser={this.setUser}/>}/>
          <Route path = "/cashIn" component= {CashIn}/>
          <Route path = "/cashOut" component= {CashOut}/> 
          <Route path = "/loyalty" component = {Loyalty}/>
          <Route path = "/profile" render= {(props) => <Profile {...props} setUser={this.setUser}/>}/>
          <Route path = "/navbar" render={(props => <Navbar {...props} userAccount={this.state.userAccount} userLogged={this.state.userLogged}/>)}/>
         </Switch> 
      </BrowserRouter>
    )
  }
}

export default App;
