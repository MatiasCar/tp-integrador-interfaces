import axios from 'axios';
import React, { useEffect, useState } from 'react';
import {useParams} from 'react-router-dom';
import Nav from './NavBar'
import Comment from './Comment'
import '../estilos/Notas.css'

function Note(){

    let { id } = useParams();
    
    
    const [nota, setNota] = useState({
        title : "",
        author : "",
        body : "",
        categories : [],
        comments : []
    })


    useEffect(()=>{
        axios.get("http://localhost:7000/content/"+id)
        .then(succes =>{
            setNota(succes.data)
           
            
        })
        .catch(error => console.log(error))
    },[]);

    return(
        <div className="body-note">
          {console.log(nota.comments)}
        <div className="note-page">
            <Nav/>
            <center><h2>{nota.title}</h2></center>
            <p className="titulo"> Autor : {nota.author}</p>
            <p className="carac">{nota.body}</p>
            <p className="titulo"> Categorias : {nota.categories.toString()}</p>
            <div className="fondo-comentarios">
            <h3>Comentarios</h3>
                {nota.comments.map(comentario=>(

                    <Comment key={comentario.id} comentario={comentario}/>
                    )
                    )}
            </div>
            </div>
            </div>
    )
}

export default Note;

