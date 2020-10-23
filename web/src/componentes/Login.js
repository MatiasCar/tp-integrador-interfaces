import React, {useState} from 'react';
import {Link, useHistory} from 'react-router-dom';
import axios from 'axios';
import '../estilos/Login.css'

function Login(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const updateEmail = evento => setEmail(evento.target.value);
    const updatePass = evento => setPassword(evento.target.value)

    let history = useHistory();


    function home(){
        history.push("/home")
    }
    
    function getUser(){
        axios.get("http://localhost:7000/user")
        .then(success => {console.log(success);
            localStorage.setItem("user", success.data.name);})
        .catch(error => console.log(error))
    }


    function singIn(){
        axios.post("http://localhost:7000/login", {email : email, password : password})
        .then(success =>{
            localStorage.setItem("tokenValido", success.headers.authorization);
            axios.defaults.headers["authorization"] = localStorage.getItem("tokenValido");
            getUser();
            home();
        })
        .catch(error =>{
            console.log(error)
        })
    }

    return(
        <div className="body-login">
           
           <div className="container">
                
           <div>
                <font className="texto-campos">
                <center><h1>MEDIUNQUIFLIX</h1></center>
                </font>
           </div>

                
           </div>
            <div className="container">
            <form className="row align-items-center">
                 <h5 className="col-md-12 texto-campos">Ingrese usuario y contraseña</h5>
                <input className="input col-md-12" type="text" placeholder="Username" name="name" value={email} onChange={updateEmail} required />
                <input className="input col-md-12" type="password" placeholder="Password " name="pass" value={password} onChange={updatePass} required />
                <button className="btn btn-primary col-md-12" type="button" onClick={singIn}>Iniciar sesion</button>
               
                <div className="texto-campos col-md-12">Aun no tienes cuenta?</div>
                <button className="btn btn-primary boton col-md-12" type="button" onClick={()=>history.push("/register")}>Registrar</button>
                <button className="btn btn-primary boton col-md-12" type="button" onClick={()=>history.push("/home")} >Volver</button> 
            </form>
            </div>
        </div>
    )
}


export default Login;