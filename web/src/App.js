import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import Home from './componentes/Home'
import Login from './componentes/Login'
import Note from './componentes/Note'
import FormRegister from './componentes/FormRegister'
import SearchPage from './componentes/SearchPage'

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login}/>
        <Route exact path="/register" component={FormRegister}/>
        <Route exact path= "/content/:id" component= {Note}/>
        <Route exact path= "/search/:search" component= {SearchPage}/>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
