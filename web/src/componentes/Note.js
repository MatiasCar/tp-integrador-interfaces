import axios from 'axios';
import React, { useEffect, useState } from 'react';
import {useParams} from 'react-router-dom';
import Nav from './NavBar'
import Comment from './Comment'

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

        <div className="note-page">
            <Nav/>
           
            <p className="titulo"> Titulo : {nota.title}</p>
            <p className="titulo"> Author : {nota.author}</p>
            <p className="carac">{nota.body}</p>
            <p className="titulo"> Categories : {nota.categories.toString()}</p>
            {nota.comments.map(comentario=>(

                <Comment key={comentario.id} comentario={comentario}/>
                )
                )}
            </div>
            </div>
    )
}

export default Note;

