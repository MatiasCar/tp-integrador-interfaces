import React, {useState} from 'react';
import {Link, useHistory} from 'react-router-dom';
import axios from 'axios';


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
        <div className="container">
        <form>
            <input className="input" type="text" placeholder="Username" name="name" value={email} onChange={updateEmail} required />
            <input className="input" type="password" placeholder="Password " name="pass" value={password} onChange={updatePass} required />
            <button className="btn btn-primary" type="button" onClick={singIn}>Iniciar sesion</button>
            Aun no tienes cuenta? <span className="register">
                <Link  to="/register">Registrar</Link>
            </span> -
            <span><Link  to="/home">Volver</Link></span>
        </form>
        
        </div>
    )
}


export default Login;