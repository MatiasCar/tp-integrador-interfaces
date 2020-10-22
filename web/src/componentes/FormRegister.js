import React, {useState} from 'react'
import { Link, useHistory } from 'react-router-dom';
import axios from "axios";

function FormRegister(){

    let history = useHistory()

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [photo, setPhoto] = useState("");

    const updateName = evento => setName(evento.target.value);
    const updateEmail = evento => setEmail(evento.target.value);
    const updatePass = evento => setPassword(evento.target.value);
    const updatePhoto = evento => setPhoto(evento.target.value);

    function registrar(){
        axios.post("http://localhost:7000/register/",{
            name : name,
            email : email,
            password : password,
            photo : photo
        })
        .then(success => history.push("/login"))
        .catch(error => console.log(error))
    }

    return(
        <div className="container">

            
            <form>
            <div className="form-group row">
                <label >Name:</label>
                <div className="col-sm-10">
                    <input className="input" type="text" placeholder="Enter name" name="name" value={name} onChange={updateName} required /> </div>
            </div>
            <div className="form-group row">
                <label>Email:</label>
                <div className="col-sm-10">
                    <input className="input" type="text" placeholder="Enter email" name="email" value={email} onChange={updateEmail} required />
                </div>
            </div>
            <div className="form-group row">
                <label>Pass:</label>
                <div className="col-sm-10">
                <input className="input" type="password" placeholder="Password " name="pass" value={password} onChange={updatePass} required /> </div>
            </div>
            <div className="form-group row">
                <label>Photo:</label>
                <div className="col-sm-10">
                <input className="input" type="text" placeholder="Photo link" name="photo" value={photo} onChange={updatePhoto} required /> </div>
            </div>    
            

            <button className="btn btn-secondary" type="button" onClick={evento => registrar(evento)}>Registrar</button>
            <span className="registro">
                <Link to="/login">Volver</Link>
            </span>
            </form>
        </div>
    );

}

export default FormRegister;
