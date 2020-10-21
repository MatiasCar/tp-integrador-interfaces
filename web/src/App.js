import React from 'react';
import {Link, BrowserRouter, Route, Switch, Redirect} from 'react-router-dom'
import Home from './componentes/Home'

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={Home} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
