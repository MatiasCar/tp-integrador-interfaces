import React, { useState } from 'react'
import {Link} from 'react-router-dom'

function NavBar(){

    const [busqueda , setBusqueda] = useState(" ");
    const updateBusqueda = evento => setBusqueda(evento.target.value)

    const verificarBusqueda = () =>{
        if(busqueda===""){
            setBusqueda(" ")
        }
    }

    return(
        <div>

            <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <Link className="navbar-brand" to="/home">Inicio</Link>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">
                
                <li className="nav-item">
                    <Link className="nav-link" to="/login">Iniciar sesion</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/register">Registrar</Link>
                </li>
                </ul>
                <form className="form-inline my-2 my-lg-0">
                <input className="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Busqueda" onChange={updateBusqueda}/>
                <Link to={"/search/"+busqueda}><button className="btn btn-outline-success my-2 my-sm-0" type="submit" onChange={verificarBusqueda()}>Buscar</button></Link>
                </form>
            </div>
            </nav>
        </div>
    );
}

export default NavBar;