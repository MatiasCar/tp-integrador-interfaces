import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import Home from './componentes/Home'
import Login from './componentes/Login'

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login}/>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
