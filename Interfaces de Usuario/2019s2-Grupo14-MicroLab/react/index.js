import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";


ReactDOM.render(<App />, document.getElementById('root'));
    /*
    //va en APP.js
    <BrowserRouter>
        <Div classNAme="App">
        <App /> document.getElementById('root')
        <Switch>
            <Route exact path="/404" component={Error404}/>
            <Route path="/">
                <Route path="/" component{Navbar} />
                    <Switch>
                        <Route exact path="/" component={Home} />
                        <Route exact path="/Login" component={Login} /> // va arriba del navbar. el login no lo necesita

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
*/
serviceWorker.unregister();


