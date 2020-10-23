import React from 'react';
import {BrowserRouter, Redirect, Route, Switch} from 'react-router-dom'
import Home from './componentes/Home'
import Login from './componentes/Login'
import Note from './componentes/Note'
import FormRegister from './componentes/FormRegister'
import SearchPage from './componentes/SearchPage'
import SearchPageCategories from './componentes/SearchPageCategories'

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Redirect to="/home"/>
        </Route>
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login}/>
        <Route exact path="/register" component={FormRegister}/>
        <Route exact path= "/content/:id" component= {Note}/>
        <Route exact path= "/search/:search" component= {SearchPage}/>
        <Route exact path= "/category/:name" component= {SearchPageCategories}/>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
