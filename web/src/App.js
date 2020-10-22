import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import Home from './componentes/Home'
import Login from './componentes/Login'
import Note from './componentes/Note'
import FormRegister from './componentes/FormRegister'

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login}/>
        <Route exact path="/register" component={FormRegister}/>
        <Route exact path= "/content/:id" component= {Note}/>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
