import axios from 'axios';
import React, { useEffect, useState } from 'react';
import {useParams} from 'react-router-dom';


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
            console.log(succes.data)
        })
        .catch(error => console.log(error))
    },[]);

    return(
        <div>
            <center>Nota especifica</center>
            <p> Titulo : {nota.title}</p>
            <p> Author : {nota.author}</p>
            <p> Description : {nota.body}</p>
            <p> Categories : {nota.categories}</p>
            
            </div>
    )
}

export default Note;