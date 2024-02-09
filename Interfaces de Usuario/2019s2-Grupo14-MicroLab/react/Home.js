import React ,{ Component } from "react";
import './Home.css'
import Navbar from './components/Navbar'
import axios from 'axios'
import { MDBListGroup, MDBListGroupItem, MDBContainer, MDBBadge, MDBIcon } from "mdbreact";  


class Home extends Component{ 
  constructor(props){
    super(props)
    this.state = { 
    userLogged:'',
    accounts:[],
    userAccount:'',
    transactions:[],
    account:''
    }
  }  

  getTransactionsFromCVU(){
    axios.get("http://localhost:7000/transaction/" + this.props.userAccount.cvu)
    .then(response => {
      this.setState({transactions: response.data})
      console.log('trans del user: ',this.state.transactions)
    })
  }

  setAccountFromUser(){
    if(this.props.userLogged === ""){
      this.getUserLogged()
    }
    let account = this.state.accounts.find(account => account.user.email === localStorage.getItem("userEmail"))
    this.setAccount(account)
    console.log('la cuenta es: ',account)
    this.getTransactionsFromCVU()
  }

  setAccount = (account) => {
    this.props.setAccount(account)
    this.setState({account:account})
  }
  
  componentDidMount() {
    axios.get("http://localhost:7000/accounts")
    .then(response => {
      console.log("GET ACCOUNTS: ", response)
      this.setState({ accounts: response.data })
      console.log('cuentas: ' ,this.state.accounts)
      if(this.props.userAccount === undefined){
        this.props.setAccount(this.state.account)
      }
      this.setAccountFromUser()
    })
  }
  

  getAccounts(){
    axios.get("http://localhost:7000/accounts")
    .then(response => {
      console.log("GET ACCOUNTS: ", response)
      this.setState({ accounts: response.data })
    })  
  }

  getUserLogged(){
    axios.get("http://localhost:7000/users/" + localStorage.getItem("userEmail"))
      .then(response => {
        this.setUser(response.data)
      })
  }

  setUser = (user) => {
    this.props.setUser(user)
    this.setState({userLogged:user})
  }

  render(){
    
    if(this.props.userAccount === undefined){
      return null
    }else{
      return(
        <div>
          <Navbar/>
          <div>
          
            <MDBIcon icon="user-alt"> <h3 className='user'> Usuario:{this.props.userLogged.firstName} {this.props.userLogged.lastName}</h3> </MDBIcon>
            <h4 className='usersaldo'> Saldo: {this.props.userAccount.balance}</h4>
            <h2 className='title'> Transacciones</h2>
            <br></br>
            <div>
            {this.state.transactions.map(t => { if(t.cashOut)
              {return<MDBContainer>
              <MDBListGroup style={{ width: "70rem" }}>
            
                <MDBListGroupItem className="d-flex justify-content-between align-items-center">{t.date.dayOfMonth}-{t.date.monthValue}-{t.date.year} <span>     </span>
                {t.description}<span>     </span><MDBBadge color="danger" pill>{t.amount}</MDBBadge>
                </MDBListGroupItem>
              </MDBListGroup>
            </MDBContainer>}else{
              return<MDBContainer>
              <MDBListGroup style={{ width: "70rem" }}>
            
                <MDBListGroupItem className="d-flex justify-content-between align-items-center">{t.date.dayOfMonth}-{t.date.monthValue}-{t.date.year} <span>     </span>
                {t.description}<span>     </span><MDBBadge color="primary" pill>{t.amount}</MDBBadge>
                </MDBListGroupItem>
              </MDBListGroup>
            </MDBContainer>

            }
            })}
            </div>
          </div> 
        </div>     
      )

    }
  }
  
}

export default Home;